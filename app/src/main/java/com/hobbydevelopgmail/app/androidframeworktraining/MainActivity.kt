package com.hobbydevelopgmail.app.androidframeworktraining

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.hobbydevelopgmail.app.androidframeworktraining.Home.HomeFragment
import com.hobbydevelopgmail.app.androidframeworktraining.Other.OtherFragment
import com.hobbydevelopgmail.app.androidframeworktraining.Todo.TodoListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {
            R.id.bottom_navigation_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, HomeFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.bottom_navigation_todo_list -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, TodoListFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.bottom_navigation_other -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, OtherFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configure()
    }

    private fun configure() {
        // 表示の初期化
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, HomeFragment())
            .commit()

        // BottomNavigationViewの初期化
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}

