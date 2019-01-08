package com.hobbydevelopgmail.app.androidframeworktraining.todo

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hobbydevelopgmail.app.androidframeworktraining.R
import com.hobbydevelopgmail.app.androidframeworktraining.common.NavigationController
import com.hobbydevelopgmail.app.androidframeworktraining.databinding.ActivityTodoEditBinding

class TodoEditActivity : AppCompatActivity() {

    lateinit var binding: ActivityTodoEditBinding
    lateinit var editViewModel: TodoEditViewModel

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
        /*
            Databinding
            Databindingを利用して双方向バインディングを実現します。
            View（ActivityやFragment）は参照や更新はせずにViewModelが行います。
            例えばボタンのクリック時のonClickはViewModelが担当します。
            画面遷移の場合はViewModelはView(ActivityやFragment)を知らないのでNavigatorを使って画面遷移をします。
         */
        binding = DataBindingUtil.setContentView<ActivityTodoEditBinding>(this, R.layout.activity_todo_edit)
        val navigationController: NavigationController = NavigationController(this)
        editViewModel = TodoEditViewModel(navigationController)
        binding.viewModel = editViewModel
        editViewModel.text = "sample"
    }
}
