package com.khoofiya.realnews.pojos

import io.realm.RealmObject

open class ArticleSource(
    var id: String? = null,
    var name: String? = null
) : RealmObject()