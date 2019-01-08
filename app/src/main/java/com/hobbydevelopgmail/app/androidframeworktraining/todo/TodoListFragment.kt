package com.hobbydevelopgmail.app.androidframeworktraining.todo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hobbydevelopgmail.app.androidframeworktraining.R
import com.hobbydevelopgmail.app.androidframeworktraining.todo.presentation.TodoEditActivity
import kotlinx.android.synthetic.main.fragment_todo_list.*

class TodoListFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // 該当するLayoutを設定
        return inflater.inflate(R.layout.fragment_todo_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configure()
    }

    private fun configure() {
        dummyButton.setOnClickListener {
            activity?.let {
                val intent = TodoEditActivity.createIntent(it)
                startActivity(intent)
            }

        }
    }
}