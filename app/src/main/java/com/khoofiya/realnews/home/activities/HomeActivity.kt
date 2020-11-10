package com.khoofiya.realnews.home.activities

import android.os.Bundle
import com.khoofiya.realnews.R
import com.khoofiya.realnews.base.viewModels.BaseViewModel
import com.khoofiya.realnews.base.views.BaseActivity
import com.khoofiya.realnews.home.viewModels.HomeViewModel

class HomeActivity : BaseActivity() {

    private var mViewModel: HomeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mViewModel = createViewModel(HomeViewModel::class.java)
        mViewModel?.testAPICall()
    }

}