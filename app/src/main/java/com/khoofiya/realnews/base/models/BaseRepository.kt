package com.khoofiya.realnews.base.models

import android.util.Log
import com.khoofiya.realnews.base.datamanager.DataManager
import com.khoofiya.realnews.base.networking.RetrofitController
import io.realm.Realm
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseRepository(private val dataManager: DataManager) {

    protected var mRetrofitController: RetrofitController = dataManager.getRetrofitController()

    protected var mRealm: Realm = dataManager.getRealm()

    protected fun <T> executeRequest(
        requestCall: Call<T>?,
        onSuccess: (T?) -> Unit,
        onError: () -> Unit
    ) {
        requestCall?.enqueue(object : Callback<T> {

            override fun onResponse(call: Call<T>, response: Response<T>) {
                Log.d("executeRequest", "onResponse: $response")
                onSuccess.invoke(response.body())
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                Log.d("executeRequest", "onFailure: $t")
                onError.invoke()
            }

        })
    }

    fun tesAPICall() {
        executeRequest(mRetrofitController.apis?.getSources(),
            {
                Log.d("tesAPICall", "Success Response:\n$it")
            },
            {
                Log.d("tesAPICall", "Error")
            })
    }

}