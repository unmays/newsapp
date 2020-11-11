package com.khoofiya.realnews.pojos

import io.realm.RealmObject

open class Source(
    var category: String? = null,
    var country: String? = null,
    var description: String? = null,
    var id: String? = null,
    var language: String? = null,
    var name: String? = null,
    var url: String? = null
) : RealmObject()