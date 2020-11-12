package com.khoofiya.realnews.base.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.khoofiya.realnews.RealNewsApplication
import com.khoofiya.realnews.base.viewModels.BaseViewModel
import com.khoofiya.realnews.base.viewModels.DIViewModelFactory
import javax.inject.Inject

abstract class BaseFragment : Fragment() {

    @Inject
    internal lateinit var mViewModelFactory: DIViewModelFactory

    protected fun <T : BaseViewModel> createViewModel(viewModelClass: Class<T>): T {
        return createViewModel(viewModelClass, this)
    }

    protected fun <T : BaseViewModel> createViewModel(
        viewModelClass: Class<T>,
        viewModelStoreOwner: ViewModelStoreOwner
    ): T {
        return ViewModelProvider(
            viewModelStoreOwner,
            mViewModelFactory
        ).get(viewModelClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as RealNewsApplication).appComponent.injectFragment(this)
    }

}