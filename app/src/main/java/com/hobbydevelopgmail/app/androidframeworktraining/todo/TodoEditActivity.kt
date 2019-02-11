package com.hobbydevelopgmail.app.androidframeworktraining.todo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hobbydevelopgmail.app.androidframeworktraining.R
import kotlinx.android.synthetic.main.activity_todo_edit.*

class TodoEditActivity : AppCompatActivity() {

    companion object {
        const val LOG_TAG = "TODO_EDIT_ACTIVITY_LOG"
        fun createIntent(context: Context): Intent {
            return Intent(context, TodoEditActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_edit)
        configure()
    }

    private fun configure() {

        // EditText
        inputEditText.setText("")

        // SaveButton押下時の処理
        saveButton.setOnClickListener {
            // 保存する
            println("save")
        }

        // clearButton押下時の処理
        clearButton.setOnClickListener {
            // EditTextの内容をクリア
            inputEditText.setText("")
        }
    }
}
