package com.khoofiya.realnews.base.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.khoofiya.realnews.R
import com.khoofiya.realnews.base.viewModels.BaseViewModel

class BaseActivity : AppCompatActivity() {

    private var mViewModel: BaseViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(BaseViewModel::class.java)
        mViewModel?.testAPICall()
//            ViewModelProviders.of(this).get(BaseViewModel::class.java)
    }
}