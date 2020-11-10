package com.khoofiya.realnews.base.viewModels

import androidx.lifecycle.ViewModel
import com.khoofiya.realnews.base.datamanager.DataManager
import com.khoofiya.realnews.base.models.BaseRepository

open class BaseViewModel(private val dataManager: DataManager) : ViewModel() {

    private var repository =
        BaseRepository(dataManager.getRetrofitController(), dataManager.getRealm())

    fun testAPICall() {
        repository.tesAPICall()
    }

}