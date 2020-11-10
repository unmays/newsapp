package com.khoofiya.realnews.home.viewModels

import com.khoofiya.realnews.base.datamanager.DataManager
import com.khoofiya.realnews.base.viewModels.BaseViewModel
import com.khoofiya.realnews.home.repositories.HomeRepository

class HomeViewModel(private val dataManager: DataManager) :
    BaseViewModel(dataManager = dataManager) {

    private val homeRepository = HomeRepository(dataManager)

}
