package com.khoofiya.realnews.di.components

import android.app.Application
import com.khoofiya.realnews.RealNewsApplication
import com.khoofiya.realnews.base.networking.RetrofitController
import com.khoofiya.realnews.di.modules.ApplicationModule
import com.khoofiya.realnews.utils.SharedPreferencesUtil
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class])
interface ApplicationComponent: AndroidInjector<RealNewsApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }

}