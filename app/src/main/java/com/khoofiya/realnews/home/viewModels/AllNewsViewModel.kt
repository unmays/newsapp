package com.khoofiya.realnews.home.viewModels

import androidx.lifecycle.MutableLiveData
import com.khoofiya.realnews.base.datamanager.DataManager
import com.khoofiya.realnews.base.viewModels.BaseViewModel
import com.khoofiya.realnews.pojos.Article
import com.khoofiya.realnews.repositories.AllNewsRepository

class AllNewsViewModel(dataManager: DataManager) : BaseViewModel(dataManager = dataManager) {

    private val allNewsRepository = AllNewsRepository(dataManager)

    private lateinit var articles: MutableLiveData<List<Article>?>

    fun getAllNews(): MutableLiveData<List<Article>?> {
        articles =
            allNewsRepository.getAllNews(q = "(agriculture OR agri) AND (technology OR tech)")
        return articles
    }

    fun getNextPage(page: Int) {
        allNewsRepository.getNextPage(
            page = page,
            q = "(agriculture OR agri) AND (technology OR tech)"
        )
    }

}