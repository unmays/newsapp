package com.khoofiya.realnews.home.viewModels

import androidx.lifecycle.MutableLiveData
import com.khoofiya.realnews.base.datamanager.DataManager
import com.khoofiya.realnews.base.viewModels.BaseViewModel
import com.khoofiya.realnews.home.repositories.AllNewsRepository
import com.khoofiya.realnews.pojos.Article

class AllNewsViewModel(dataManager: DataManager) : BaseViewModel(dataManager = dataManager) {

    private val sourcesRepository = AllNewsRepository(dataManager)

    private lateinit var articles: MutableLiveData<List<Article>?>

    fun getAllNews(): MutableLiveData<List<Article>?> {
        articles = sourcesRepository.getAllNews()
        return articles
    }

}