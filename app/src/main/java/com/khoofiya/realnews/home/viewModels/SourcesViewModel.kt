package com.khoofiya.realnews.home.viewModels

import androidx.lifecycle.MutableLiveData
import com.khoofiya.realnews.base.datamanager.DataManager
import com.khoofiya.realnews.base.viewModels.BaseViewModel
import com.khoofiya.realnews.repositories.SourcesRepository
import com.khoofiya.realnews.pojos.Source

class SourcesViewModel(dataManager: DataManager) : BaseViewModel(dataManager = dataManager) {

    private val sourcesRepository = SourcesRepository(dataManager)

    private lateinit var sources: MutableLiveData<List<Source>?>

    fun getSources(): MutableLiveData<List<Source>?> {
        sources = sourcesRepository.getSources()
        return sources
    }

}