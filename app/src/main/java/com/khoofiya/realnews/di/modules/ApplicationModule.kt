package com.khoofiya.realnews.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.khoofiya.realnews.base.networking.RetrofitController
import com.khoofiya.realnews.di.annotations.AnnotateRealm
import com.khoofiya.realnews.di.annotations.AnnotateRetrofitController
import com.khoofiya.realnews.di.annotations.SharedPrefs
import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @SharedPrefs
    fun provideSharedPreferences(): SharedPreferences {
        return application.getSharedPreferences("real-news-shared-pref", Context.MODE_PRIVATE)
    }

    @Provides
    @AnnotateRetrofitController
    fun provideRetrofitController(): RetrofitController {
        return RetrofitController.getInstance("https://newsapi.org")
    }

    @Provides
    @AnnotateRealm
    fun provideRealm(): Realm {
        return Realm.getDefaultInstance()
    }

}