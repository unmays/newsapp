package com.khoofiya.realnews.utils

import java.text.ParseException
import java.text.SimpleDateFormat

val SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
val SERVER_DATE_FORMAT2 = "yyyy-MM-dd'T'HH:mm:ss.S'Z'"
val CLIENT_DATE_FORMAT = "dd MMM yyyy, HH:mm a"
val serverDateFormat = SimpleDateFormat(SERVER_DATE_FORMAT)
val serverDateFormat2 = SimpleDateFormat(SERVER_DATE_FORMAT2)
val clientDateFormat = SimpleDateFormat(CLIENT_DATE_FORMAT)

fun convertPublishedAtDate(publishedAt: String): String {
    val serverFormattedDate =
        try {
            serverDateFormat.parse(publishedAt)
        } catch (e: ParseException) {
            serverDateFormat2.parse(publishedAt)
        }
    return clientDateFormat.format(serverFormattedDate)
}