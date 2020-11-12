package com.khoofiya.realnews.sourceheadlines.viewModels

import androidx.lifecycle.MutableLiveData
import com.khoofiya.realnews.base.datamanager.DataManager
import com.khoofiya.realnews.base.viewModels.BaseViewModel
import com.khoofiya.realnews.pojos.Article
import com.khoofiya.realnews.repositories.TopHeadlinesRepository

class TopHeadlinesViewModel(dataManager: DataManager) : BaseViewModel(dataManager = dataManager) {

    private val topHeadlinesRepository = TopHeadlinesRepository(dataManager)

    private lateinit var articles: MutableLiveData<List<Article>?>

    fun getTopHeadlines(sourceId: String?): MutableLiveData<List<Article>?> {
        articles = topHeadlinesRepository.getTopHeadlines(sourceId = sourceId)
        return articles
    }

}