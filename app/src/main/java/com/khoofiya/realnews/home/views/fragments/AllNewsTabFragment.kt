package com.khoofiya.realnews.home.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.khoofiya.realnews.R
import com.khoofiya.realnews.base.views.BaseFragment
import com.khoofiya.realnews.home.viewModels.AllNewsViewModel
import com.khoofiya.realnews.home.views.adapters.AllNewsAdapter
import com.khoofiya.realnews.utils.startArticleDetailsActivity
import kotlinx.android.synthetic.main.fragment_all_news_tab.*

class AllNewsTabFragment : BaseFragment() {

    private lateinit var mViewModel: AllNewsViewModel
    private var pageEndListener: PageEndListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = createViewModel(AllNewsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_all_news_tab, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.getAllNews().observe(viewLifecycleOwner,
            Observer { articlesList ->
                articlesList?.let { articles ->
                    if (allNewsRV.adapter == null) {
                        allNewsRV.adapter = AllNewsAdapter(articles) { article ->
                            activity?.let { it -> startArticleDetailsActivity(it, article) }
                        }
                        allNewsRV.layoutManager =
                            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                        pageEndListener =
                            PageEndListener((allNewsRV.layoutManager as LinearLayoutManager)) {
                                mViewModel.getNextPage(it)
                            }
                        pageEndListener?.let { allNewsRV.addOnScrollListener(it) }
                    } else {
                        (allNewsRV.adapter as AllNewsAdapter).articles =
                            (allNewsRV.adapter as AllNewsAdapter).articles + articles
                        allNewsRV.adapter?.notifyDataSetChanged()
                    }
                }
                pageEndListener?.isLoading = false
            }
        )
    }

}