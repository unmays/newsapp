package com.khoofiya.realnews.home.repositories

import com.khoofiya.realnews.base.datamanager.DataManager
import com.khoofiya.realnews.base.models.BaseRepository

class HomeRepository(private val dataManager: DataManager) :
    BaseRepository(dataManager = dataManager) {
}