package com.khoofiya.realnews.home.views.activities

import android.os.Bundle
import com.khoofiya.realnews.R
import com.khoofiya.realnews.base.views.BaseActivity
import com.khoofiya.realnews.home.viewModels.HomeViewModel
import com.khoofiya.realnews.home.views.adapters.HomeTabsPagerAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    private var mViewModel: HomeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val sectionsPagerAdapter =
            HomeTabsPagerAdapter(
                this,
                supportFragmentManager
            )
        homeViewPager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(homeViewPager)
        initData()
    }

    private fun initData() {
        mViewModel = createViewModel(HomeViewModel::class.java)
    }

}