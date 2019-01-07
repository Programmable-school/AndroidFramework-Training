package com.hobbydevelopgmail.app.androidframeworktraining

import android.app.Application
import android.util.Log

class App: Application() {

    companion object {
        val TAG: String = "TAG_APP"
    }

    override fun onCreate() {
        super.onCreate()
        configure()
    }

    private fun configure() {
        /* ここで起動時のライブラリの初期化処理等を行う */
        Log.d(TAG, "app configure")
    }


}