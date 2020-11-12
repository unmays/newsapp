package com.khoofiya.realnews.pojos

data class ArticlesResponse(
    val articles: List<Article>?,
    val status: String?,
    val totalResults: Int?
)