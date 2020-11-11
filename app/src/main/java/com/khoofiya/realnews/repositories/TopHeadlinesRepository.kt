package com.khoofiya.realnews.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.khoofiya.realnews.base.datamanager.DataManager
import com.khoofiya.realnews.base.models.BaseRepository
import com.khoofiya.realnews.pojos.Article
import com.khoofiya.realnews.utils.STATUS_OK
import io.realm.ImportFlag

class TopHeadlinesRepository(private val dataManager: DataManager) :
    BaseRepository(dataManager = dataManager) {

    private val articles: MutableLiveData<List<Article>?> = MutableLiveData()

    fun getTopHeadlines(sourceId: String?): MutableLiveData<List<Article>?> {
        getTopHeadlinesFromLocal(sourceId)
        executeRequest(mRetrofitController.apis?.getTopHeadlines(sources = sourceId),
            {
                if (it?.status == STATUS_OK) {
                    articles.value = it.articles
                    updateSourcesInLocal(it.articles)
                }
            },
            {
                Log.d("tesAPICall", "Error")
            })
        return articles
    }

    private fun getTopHeadlinesFromLocal(sourceId: String?) {
        articles.value =
            mRealm.where(Article::class.java).equalTo("source.id", sourceId).findAllAsync()
                .distinct()
    }

    private fun updateSourcesInLocal(articles: List<Article>?) {
        articles?.let {
            mRealm.beginTransaction()
            mRealm.copyToRealmOrUpdate(it, ImportFlag.CHECK_SAME_VALUES_BEFORE_SET)
            mRealm.commitTransaction()
        }
    }

}