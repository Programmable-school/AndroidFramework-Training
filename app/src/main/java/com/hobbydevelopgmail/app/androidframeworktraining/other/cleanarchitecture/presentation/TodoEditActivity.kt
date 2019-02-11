package com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.presentation

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hobbydevelopgmail.app.androidframeworktraining.R
import com.hobbydevelopgmail.app.androidframeworktraining.common.NavigationController
import com.hobbydevelopgmail.app.androidframeworktraining.databinding.ActivityCleanarchitectureTodoEditBinding
import com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.domain.usecase.ReadTodoUseCase
import com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.domain.usecase.WriteTodoUseCase
import com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.infrastructure.datasource.TodoEditDataSource

class TodoEditActivity : AppCompatActivity() {

    lateinit var binding: ActivityCleanarchitectureTodoEditBinding
    lateinit var viewModel: TodoEditViewModel
    lateinit var navigationController: NavigationController
    lateinit var readTodoUseCase: ReadTodoUseCase
    lateinit var writeTodoUseCase: WriteTodoUseCase

    companion object {
        const val LOG_TAG = "TODO_EDIT_ACTIVITY_LOG"
        fun createIntent(context: Context): Intent {
            return Intent(context, TodoEditActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cleanarchitecture_todo_edit)
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
        binding = DataBindingUtil.setContentView<ActivityCleanarchitectureTodoEditBinding>(this, R.layout.activity_cleanarchitecture_todo_edit)

        // 「書き込み」「読み込み」のUseCaseを注入する
        val todoEditRepository: TodoEditDataSource = TodoEditDataSource(this)
        readTodoUseCase = ReadTodoUseCase(todoEditRepository)
        writeTodoUseCase = WriteTodoUseCase(todoEditRepository)
        navigationController = NavigationController(this)

        // ViewModelにUseCaseとNavigatorを注入
        viewModel = TodoEditViewModel(readTodoUseCase, writeTodoUseCase, navigationController)
        binding.viewModel = viewModel
        viewModel.configure()
    }
}
