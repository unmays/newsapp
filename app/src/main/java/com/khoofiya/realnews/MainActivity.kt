package com.khoofiya.realnews

import android.os.Bundle
import com.khoofiya.realnews.base.viewModels.BaseViewModel
import com.khoofiya.realnews.base.views.BaseActivity

class MainActivity : BaseActivity() {

    private var mViewModel: BaseViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = createViewModel(BaseViewModel::class.java)
        mViewModel?.testAPICall()
    }

}