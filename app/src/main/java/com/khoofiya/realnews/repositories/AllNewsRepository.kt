package com.khoofiya.realnews.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.khoofiya.realnews.base.datamanager.DataManager
import com.khoofiya.realnews.base.models.BaseRepository
import com.khoofiya.realnews.pojos.Article
import com.khoofiya.realnews.utils.STATUS_OK
import io.realm.ImportFlag

class AllNewsRepository(private val dataManager: DataManager) :
    BaseRepository(dataManager = dataManager) {

    private val articles: MutableLiveData<List<Article>?> = MutableLiveData()

    fun getAllNews(
        page: Int? = 1,
        q: String? = null,
        qInTitle: String? = null,
        sources: String? = null,
        domains: String? = null,
        excludeDomains: String? = null,
        from: String? = null,
        to: String? = null,
        language: String? = null,
        sortBy: String? = null,
        pageSize: Int? = null
    ): MutableLiveData<List<Article>?> {
        getArticlesFromLocal()
        executeRequest(mRetrofitController.apis?.getEverything(
            page = page,
            q = q,
            qInTitle = qInTitle,
            sources = sources,
            domains = domains,
            excludeDomains = excludeDomains,
            from = from,
            to = to,
            language = language,
            sortBy = sortBy,
            pageSize = pageSize
        ),
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

    private fun getArticlesFromLocal() {
        articles.value = mRealm.where(Article::class.java).findAllAsync().distinct()
    }

    private fun updateSourcesInLocal(articles: List<Article>?) {
        articles?.let {
            mRealm.beginTransaction()
            mRealm.copyToRealmOrUpdate(it, ImportFlag.CHECK_SAME_VALUES_BEFORE_SET)
            mRealm.commitTransaction()
        }
    }

}