package com.hobbydevelopgmail.app.androidframeworktraining.other

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hobbydevelopgmail.app.androidframeworktraining.R

class OtherFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // 該当するLayoutを設定
        return inflater.inflate(R.layout.fragment_other, container, false)
    }
}