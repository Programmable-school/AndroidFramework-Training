package com.hobbydevelopgmail.app.androidframeworktraining.common

import android.app.Activity
import android.support.v7.app.AppCompatActivity


class NavigationController(private val activity: AppCompatActivity) {

    // Activity終了
    fun closeActivity() {
        activity.setResult(Activity.RESULT_OK)
        activity.finish()
    }

    fun showDialog() {

    }
}