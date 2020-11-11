package com.khoofiya.realnews.pojos

import io.realm.RealmObject

open class Article(
    var author: String? = null,
    var content: String? = null,
    var description: String? = null,
    var publishedAt: String? = null,
    var source: ArticleSource? = null,
    var title: String? = null,
    var url: String? = null,
    var urlToImage: String? = null
) : RealmObject() {

}