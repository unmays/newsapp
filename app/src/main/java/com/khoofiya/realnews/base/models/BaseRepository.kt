package com.khoofiya.realnews.base.models

import android.util.Log
import com.khoofiya.realnews.base.networking.RetrofitController
import com.khoofiya.realnews.di.annotations.AnnotateRealm
import com.khoofiya.realnews.di.annotations.AnnotateRetrofitController
import io.realm.Realm
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BaseRepository {

    /*@Inject*/
    protected var mRetrofitController: RetrofitController

    /*@Inject*/
    protected var mRealm: Realm

    /*@Inject*/
    constructor(@AnnotateRetrofitController retrofitController: RetrofitController, @AnnotateRealm realm: Realm) {
        mRetrofitController = retrofitController
        mRealm = realm
    }

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
        executeRequest(mRetrofitController.apis?.getAllArticles(),
            {
                Log.d("tesAPICall", "Success Response:\n$it")
            },
            {
                Log.d("tesAPICall", "Error")
            })
    }

}