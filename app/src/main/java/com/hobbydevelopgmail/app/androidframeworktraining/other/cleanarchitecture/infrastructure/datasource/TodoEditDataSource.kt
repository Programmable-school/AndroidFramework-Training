package com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.infrastructure.datasource

import android.content.Context
import android.content.SharedPreferences
import com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.domain.model.TodoEditModel
import com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.domain.repository.TodoEditRepository
import com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.infrastructure.entity.TodoEditEntity

class TodoEditDataSource(private val context: Context): TodoEditRepository {

    var mSharedData: SharedPreferences
    private var todoEditEntity: TodoEditEntity? = null

    companion object {
        const val DATA_STORE: String = "data_store"                     // SharedPreferenceの設定データID
        const val DATA_STORE_TODO_TEXT: String = "data_store_todo_text" // 設定データに記録するデータID
    }

    init {
        mSharedData = context.getSharedPreferences(DATA_STORE, Context.MODE_PRIVATE)
    }

    /*
        Entity -> Modelに変換して返す
        Entityは外部から取得したデータを格納
        Entity -> Modelによってシステム上扱うモデルクラスへ変換するイメージ
     */
    override fun readTodoEditModel(): TodoEditModel {
        val text = mSharedData.getString(DATA_STORE_TODO_TEXT, "")
        val todoEditModel: TodoEditModel = TodoEditModel("")
        todoEditEntity = TodoEditEntity(text)
        todoEditEntity?.let {
            todoEditModel.text = it.text
        }
        return todoEditModel
    }

    override fun writeTodoEditModel(todoEditModel: TodoEditModel) {
        todoEditEntity = TodoEditEntity(todoEditModel.text)
        todoEditEntity?.let {
            val editr = mSharedData.edit()
            editr.putString(DATA_STORE_TODO_TEXT, it.text)
            editr.commit()
        }
    }
}