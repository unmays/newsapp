package com.khoofiya.realnews.di.modules

import android.app.Application
import android.content.Context
import com.khoofiya.realnews.base.datamanager.DataManager
import com.khoofiya.realnews.base.networking.RetrofitController
import com.khoofiya.realnews.utils.SharedPreferencesUtil
import dagger.Module
import dagger.Provides
import io.realm.Realm
import javax.inject.Singleton

@Module
class ApplicationModule {

    /*@Inject
    internal lateinit var application: Application*/

    @Provides
    @Singleton
    fun provideDataManager(application: Application) = DataManager(
        provideRetrofitController(),
        provideRealm(),
        SharedPreferencesUtil(provideSharedPreferences(application))
    )

    @Singleton
    private fun provideSharedPreferences(application: Application) =
        application.getSharedPreferences("real-news-shared-pref", Context.MODE_PRIVATE)

    @Singleton
    private fun provideRetrofitController() = RetrofitController.getInstance("https://newsapi.org")

    @Singleton
    private fun provideRealm() = Realm.getDefaultInstance()

}