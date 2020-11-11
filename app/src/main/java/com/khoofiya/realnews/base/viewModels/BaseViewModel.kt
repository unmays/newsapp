package com.khoofiya.realnews.base.viewModels

import androidx.lifecycle.ViewModel
import com.khoofiya.realnews.base.datamanager.DataManager

open class BaseViewModel(private val dataManager: DataManager) : ViewModel() {}