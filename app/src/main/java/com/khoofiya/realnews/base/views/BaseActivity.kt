package com.khoofiya.realnews.base.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.khoofiya.realnews.RealNewsApplication
import com.khoofiya.realnews.base.viewModels.BaseViewModel
import com.khoofiya.realnews.base.viewModels.DIViewModelFactory
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    internal lateinit var mViewModelFactory: DIViewModelFactory

    protected fun <T : BaseViewModel> createViewModel(viewModelClass: Class<T>): T {
        return ViewModelProvider(
            this,
            mViewModelFactory
        ).get(viewModelClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as RealNewsApplication).appComponent.injectActivity(this)
    }
}