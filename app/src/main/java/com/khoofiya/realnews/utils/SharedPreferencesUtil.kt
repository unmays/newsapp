package com.khoofiya.realnews.utils

import android.content.SharedPreferences
import com.khoofiya.realnews.di.annotations.SharedPrefs
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesUtil {

    private var mSharedPreferences: SharedPreferences? = null

    @Inject
    constructor(@SharedPrefs sharedPreferences: SharedPreferences?){
        mSharedPreferences = sharedPreferences
    }

    fun put(key: String?, value: String?) {
        mSharedPreferences?.edit()?.putString(key, value)?.apply()
    }

    fun put(key: String?, value: Int) {
        mSharedPreferences?.edit()?.putInt(key, value)?.apply()
    }

    fun put(key: String?, value: Float) {
        mSharedPreferences?.edit()?.putFloat(key, value)?.apply()
    }

    fun put(key: String?, value: Boolean) {
        mSharedPreferences?.edit()?.putBoolean(key, value)?.apply()
    }

    operator fun get(key: String?, defaultValue: String?): String? {
        return mSharedPreferences?.getString(key, defaultValue)
    }

    operator fun get(key: String?, defaultValue: Int): Int? {
        return mSharedPreferences?.getInt(key, defaultValue)
    }

    operator fun get(key: String?, defaultValue: Float): Float? {
        return mSharedPreferences?.getFloat(key, defaultValue)
    }

    operator fun get(key: String?, defaultValue: Boolean): Boolean? {
        return mSharedPreferences?.getBoolean(key, defaultValue)
    }

    fun deleteSavedData(key: String?) {
        mSharedPreferences?.edit()?.remove(key)?.apply()
    }

}