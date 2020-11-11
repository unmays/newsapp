package com.khoofiya.realnews.home.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.khoofiya.realnews.R
import com.khoofiya.realnews.base.views.BaseFragment
import com.khoofiya.realnews.home.viewModels.SourcesViewModel

class SourcesTabFragment : BaseFragment() {

    private lateinit var mViewModel: SourcesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = createViewModel(SourcesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_sources_tab, container, false)
        mViewModel.getSources().observe(viewLifecycleOwner,
            Observer {

            }
        )
        return root
    }

}