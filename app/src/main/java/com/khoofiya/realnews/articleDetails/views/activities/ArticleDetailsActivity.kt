package com.khoofiya.realnews.articleDetails.views.activities

import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide
import com.khoofiya.realnews.R
import com.khoofiya.realnews.articleDetails.viewModels.ArticleDetailsViewModel
import com.khoofiya.realnews.base.views.BaseActivity
import com.khoofiya.realnews.pojos.Article
import com.khoofiya.realnews.utils.ARTICLE_CONTENT_MORE_REGEX
import com.khoofiya.realnews.utils.EXTRA_PARAMS_ARTICLE
import com.khoofiya.realnews.utils.convertPublishedAtDate
import com.khoofiya.realnews.utils.replaceString
import kotlinx.android.synthetic.main.activity_article_details.*


class ArticleDetailsActivity : BaseActivity() {

    private var mViewModel: ArticleDetailsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)
        initData()
    }

    private fun initData() {
        mViewModel = createViewModel(ArticleDetailsViewModel::class.java)
        val article: Article? = intent.extras?.getParcelable(EXTRA_PARAMS_ARTICLE)
        article?.run {
            this@ArticleDetailsActivity.title = source?.name
            Glide.with(this@ArticleDetailsActivity).load(urlToImage).into(articleDetailsImage)
            articleDetailsHeading.text = title
            articleDetailsSubHeading.text = description
            articleDetailsAuthor.text = author
            articleDetailsPublishedAt.text =
                publishedAt?.let { convertPublishedAtDate(publishedAt = it) }
            if (content != null) {
                val updatedContent = HtmlCompat.fromHtml(
                    replaceString(
                        ARTICLE_CONTENT_MORE_REGEX,
                        content!!,
                        getString(R.string.read_more)
                    ), HtmlCompat.FROM_HTML_MODE_LEGACY
                );
                val readMoreClickableSpan =
                    Spannable.Factory.getInstance().newSpannable(updatedContent)
                val spanStartIndex =
                    updatedContent.lastIndexOf("[${getString(R.string.read_more)}]")
                val spanEndIndex = spanStartIndex + "[${getString(R.string.read_more)}]".length
                readMoreClickableSpan.setSpan(object : ClickableSpan() {
                    override fun onClick(view: View) {
                        val builder = CustomTabsIntent.Builder()
                        val customTabsIntent = builder.build()
                        customTabsIntent.launchUrl(this@ArticleDetailsActivity, Uri.parse(url))
                    }
                }, spanStartIndex, spanEndIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                articleDetailsContent.text = readMoreClickableSpan
                articleDetailsContent.movementMethod = LinkMovementMethod.getInstance();
            } else {
                articleDetailsContent.text = content
            }
        }
    }

}