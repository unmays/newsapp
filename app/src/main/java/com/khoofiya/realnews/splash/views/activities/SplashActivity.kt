package com.khoofiya.realnews.splash.views.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.khoofiya.realnews.home.views.activities.HomeActivity
import com.khoofiya.realnews.R
import com.khoofiya.realnews.base.views.BaseActivity


class SplashActivity : BaseActivity() {

    private val SPLASH_TIME_OUT = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(Runnable {
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
            finish()
        }, SPLASH_TIME_OUT)
    }

}