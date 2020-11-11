package com.khoofiya.realnews.home.views.activities

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.khoofiya.realnews.R
import com.khoofiya.realnews.base.views.BaseActivity
import com.khoofiya.realnews.home.views.adapters.HomeTabsPagerAdapter
import com.khoofiya.realnews.home.viewModels.HomeViewModel

class HomeActivity : BaseActivity() {

    private var mViewModel: HomeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_tabbed)
        val sectionsPagerAdapter =
            HomeTabsPagerAdapter(
                this,
                supportFragmentManager
            )
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        initData()
    }

    private fun initData() {
        mViewModel = createViewModel(HomeViewModel::class.java)
        mViewModel?.getSources()?.observe(this,
            Observer {
                Log.d(this::getLocalClassName.toString(), "Sources size = ${it?.size}")
            }
        )
    }

}