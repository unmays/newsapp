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
import kotlinx.android.synthetic.main.fragment_all_news_tab.*

class AllNewsTabFragment : BaseFragment() {

    private lateinit var mViewModel: AllNewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = createViewModel(AllNewsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_all_news_tab, container, false)
        mViewModel.getAllNews().observe(viewLifecycleOwner,
            Observer { articles ->
                articles?.let {
                    if (allNewsRV.adapter == null) {
                        allNewsRV.adapter = AllNewsAdapter(it)
                        allNewsRV.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                    } else {
                        (allNewsRV.adapter as AllNewsAdapter).articles = it
                        allNewsRV.adapter?.notifyDataSetChanged()
                    }
                }
            }
        )
        return root
    }

}