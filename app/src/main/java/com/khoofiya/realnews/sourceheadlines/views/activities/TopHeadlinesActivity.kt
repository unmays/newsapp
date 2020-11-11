package com.khoofiya.realnews.sourceheadlines.views.activities

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.khoofiya.realnews.R
import com.khoofiya.realnews.base.views.BaseActivity
import com.khoofiya.realnews.sourceheadlines.viewModels.TopHeadlinesViewModel
import com.khoofiya.realnews.sourceheadlines.views.adapters.TopHeadlinesAdapter
import com.khoofiya.realnews.utils.EXTRA_PARAMS_SOURCE_ID
import com.khoofiya.realnews.utils.startArticleDetailsActivity
import kotlinx.android.synthetic.main.activity_top_headlines.*

class TopHeadlinesActivity : BaseActivity() {

    private var mViewModel: TopHeadlinesViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_headlines)
        initData()
    }

    private fun initData() {
        mViewModel = createViewModel(TopHeadlinesViewModel::class.java)
        mViewModel?.getTopHeadlines(intent.extras?.getString(EXTRA_PARAMS_SOURCE_ID))?.observe(this,
            Observer { articles ->
                articles?.let {
                    if (topHeadlinesRV.adapter == null) {
                        topHeadlinesRV.adapter = TopHeadlinesAdapter(articles) { article ->
                            startArticleDetailsActivity(this, article)
                        }
                        topHeadlinesRV.layoutManager = LinearLayoutManager(
                            this@TopHeadlinesActivity,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                    } else {
                        (topHeadlinesRV.adapter as TopHeadlinesAdapter).articles = it
                        topHeadlinesRV.adapter?.notifyDataSetChanged()
                    }
                }
            })
    }

}