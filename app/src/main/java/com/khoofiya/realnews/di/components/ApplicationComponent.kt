package com.khoofiya.realnews.di.components

import android.app.Application
import com.khoofiya.realnews.RealNewsApplication
import com.khoofiya.realnews.base.datamanager.DataManager
import com.khoofiya.realnews.base.views.BaseActivity
import com.khoofiya.realnews.di.modules.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class])
interface ApplicationComponent : AndroidInjector<RealNewsApplication> {
    
    fun inject(application: Application)

    fun injectActivity(baseActivity: BaseActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun provideDataManager(): DataManager

}