package com.khoofiya.realnews.utils

import java.text.SimpleDateFormat

val SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
val CLIENT_DATE_FORMAT = "dd MMM yyyy, HH:mm a"

fun convertPublishedAtDate(publishedAt: String): String {
    val serverDateFormat = SimpleDateFormat(SERVER_DATE_FORMAT)
    val clientDateFormat = SimpleDateFormat(CLIENT_DATE_FORMAT)
    return clientDateFormat.format(serverDateFormat.parse(publishedAt))
}