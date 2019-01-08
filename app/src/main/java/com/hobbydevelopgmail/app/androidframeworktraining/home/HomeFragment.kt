package com.hobbydevelopgmail.app.androidframeworktraining.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hobbydevelopgmail.app.androidframeworktraining.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment() {

    lateinit var mSharedData: SharedPreferences

    companion object {
        const val DATA_STORE: String = "data_store"             // SharedPreferenceの設定データID
        const val DATA_STORE_TEXT: String = "data_store_text"   // 設定データに記録するデータID
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // 該当するLayoutを設定
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // Activityが起動後に呼ばれる
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // 初期処理
        configure()
    }

    private fun configure() {

        // Preferenceからテキストを取得して表示
        this.activity?.let {
            mSharedData = it.getSharedPreferences(DATA_STORE, Context.MODE_PRIVATE) // MODE_PRIVATE: アプリ内でのみアクセス可能
            val text = mSharedData.getString(DATA_STORE_TEXT, "")                   // 取得する。何もなければ" "が設定される
            labelTextView.setText(text)
        }

        // Saveボタンが押された時の処理
        saveButton.setOnClickListener {

            // TextViewへテキストを表示
            val text: String = inputEditText.text.toString()
            labelTextView.setText(text)

            // Preferenceへテキストを保存
            val editer = mSharedData.edit()
            editer.putString(DATA_STORE_TEXT, text)
            editer.commit()

            // EditTextの入力欄をクリア
            inputEditText.setText("")
        }
    }
}