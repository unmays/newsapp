package com.khoofiya.realnews.base.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitController private constructor(private var mBaseUrl: String){

    private val READ_TIMEOUT = 60
    private val CONNECT_TIMEOUT = 60

    private var mRetrofit: Retrofit? = null
    var apis: Apis?

    init {
        initRetrofit()
        apis = mRetrofit?.create(Apis::class.java)
    }

    companion object {

        private var sInstance: RetrofitController? = null

        fun getInstance(mBaseUrl: String): RetrofitController {
            if (sInstance == null) {
                sInstance = RetrofitController(mBaseUrl)
            }
            return sInstance!!
        }

    }

    private fun initRetrofit(): Retrofit? {
        if (mRetrofit == null) {
            val okHttpClient = getClient()
            mRetrofit = Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return mRetrofit
    }

    private fun getClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpClient.connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpClient.retryOnConnectionFailure(true)
        return okHttpClient.build()
    }

}