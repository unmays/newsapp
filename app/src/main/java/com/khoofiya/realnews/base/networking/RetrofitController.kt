package com.khoofiya.realnews.base.networking

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitController private constructor(private var mBaseUrl: String) {

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
            mRetrofit = Retrofit.Builder().apply {
                baseUrl(mBaseUrl)
                client(okHttpClient)
                addConverterFactory(GsonConverterFactory.create())
            }.build()
        }
        return mRetrofit
    }

    private fun getClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder().apply {
            readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(HeaderChangeInterceptor())
        }
        return okHttpClientBuilder.build()
    }

    internal class HeaderChangeInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val newBuilder = chain.request().newBuilder()
            newBuilder.addHeader("Authorization", "Bearer 79f595d887db436f829c842776de1cac")
            return chain.proceed(
                newBuilder.build()
            )
        }

    }

}