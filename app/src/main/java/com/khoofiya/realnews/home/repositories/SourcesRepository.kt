package com.khoofiya.realnews.home.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.khoofiya.realnews.base.datamanager.DataManager
import com.khoofiya.realnews.base.models.BaseRepository
import com.khoofiya.realnews.pojos.Article
import com.khoofiya.realnews.pojos.Source
import com.khoofiya.realnews.utils.STATUS_OK
import io.realm.ImportFlag

class SourcesRepository(private val dataManager: DataManager) :
    BaseRepository(dataManager = dataManager) {

    private val sources: MutableLiveData<List<Source>?> = MutableLiveData()
    private val articles: MutableLiveData<List<Article>?> = MutableLiveData()

    fun getSources(): MutableLiveData<List<Source>?> {
        getSourcesFromLocal()
        executeRequest(mRetrofitController.apis?.getSources(),
            {
                if (it?.status == STATUS_OK) {
                    sources.value = it.sources
                    updateSourcesInLocal(it.sources)
                }
            },
            {
                Log.d("tesAPICall", "Error")
            })
        return sources
    }

    private fun getSourcesFromLocal() {
        sources.value = mRealm.where(Source::class.java).findAllAsync().distinct()
    }

    private fun updateSourcesInLocal(sources: List<Source>?) {
        sources?.let {
            mRealm.beginTransaction()
            mRealm.copyToRealmOrUpdate(it, ImportFlag.CHECK_SAME_VALUES_BEFORE_SET)
            mRealm.commitTransaction()
        }
    }

}