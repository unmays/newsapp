package com.khoofiya.realnews

import com.khoofiya.realnews.di.components.ApplicationComponent
import com.khoofiya.realnews.di.components.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.realm.Realm

class RealNewsApplication : DaggerApplication() {

    lateinit var appComponent: ApplicationComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        Realm.init(this)
        appComponent = DaggerApplicationComponent.builder()
            .application(this)
            .build()
        return appComponent
    }

}