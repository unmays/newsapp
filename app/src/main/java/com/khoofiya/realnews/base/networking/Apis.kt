package com.khoofiya.realnews.base.networking

import retrofit2.Call
import retrofit2.http.GET

interface Apis {

    @GET("v2/everything")
    fun getAllArticles(): Call<String>

}