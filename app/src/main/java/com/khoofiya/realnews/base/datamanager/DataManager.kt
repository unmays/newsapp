package com.khoofiya.realnews.base.datamanager

import com.khoofiya.realnews.base.networking.RetrofitController
import com.khoofiya.realnews.utils.SharedPreferencesUtil
import io.realm.Realm

class DataManager constructor(
    private val retrofitController: RetrofitController,
    private val realm: Realm,
    private val sharedPreferencesUtil: SharedPreferencesUtil
) {

    fun getRetrofitController() = retrofitController

    fun getRealm() = realm

    fun getSharedPreferencesUtil() = sharedPreferencesUtil

}