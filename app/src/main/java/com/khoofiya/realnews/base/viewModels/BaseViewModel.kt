package com.khoofiya.realnews.base.viewModels

import androidx.lifecycle.ViewModel
import com.khoofiya.realnews.base.models.BaseRepository
import javax.inject.Inject

class BaseViewModel : ViewModel() {

    @Inject
    protected lateinit var repository: BaseRepository

    fun testAPICall() {
        repository.tesAPICall()
    }

}