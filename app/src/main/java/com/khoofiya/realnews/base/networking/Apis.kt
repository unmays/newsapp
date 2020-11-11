package com.khoofiya.realnews.base.networking

import com.khoofiya.realnews.pojos.ArticlesResponse
import com.khoofiya.realnews.pojos.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Apis {

    @GET("v2/everything")
    fun getEverything(
        @Query("page") page: Int? = 1,
        @Query("q") q: String? = null,
        @Query("qInTitle") qInTitle: String? = null,
        @Query("sources") sources: String? = null,
        @Query("domains") domains: String? = null,
        @Query("excludeDomains") excludeDomains: String? = null,
        @Query("from") from: String? = null,
        @Query("to") to: String? = null,
        @Query("language") language: String? = null,
        @Query("sortBy") sortBy: String? = null,
        @Query("pageSize") pageSize: Int? = null
    ): Call<ArticlesResponse>

    @GET("v2/sources")
    fun getSources(
        @Query("category") category: String? = null,
        @Query("language") language: String? = null,
        @Query("country") country: String? = null
    ): Call<SourcesResponse>

    @GET("v2/top-headlines")
    fun getTopHeadlines(
        @Query("page") page: Int? = 1,
        @Query("q") q: String? = null,
        @Query("category") category: String? = null,
        @Query("sources") sources: String? = null,
        @Query("country") country: String? = null,
        @Query("pageSize") pageSize: Int? = null
    ): Call<ArticlesResponse>

}