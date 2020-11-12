package com.khoofiya.realnews.utils

import android.content.Context
import android.content.Intent
import com.khoofiya.realnews.articleDetails.views.activities.ArticleDetailsActivity
import com.khoofiya.realnews.pojos.Article
import java.util.regex.Pattern

val ARTICLE_CONTENT_MORE_REGEX = "[\\+][0-9]+[\\s][c][h][a][r][s]"

fun replaceString(regex: String, content: String, newString: String): String {
    val pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE)
    return pattern.matcher(content).replaceAll(newString)
}

fun startArticleDetailsActivity(context: Context, article: Article) {
    context.startActivity(Intent(context, ArticleDetailsActivity::class.java).apply {
        putExtra(EXTRA_PARAMS_ARTICLE, article)
    })
}