package com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.presentation

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.hobbydevelopgmail.app.androidframeworktraining.BR
import com.hobbydevelopgmail.app.androidframeworktraining.common.NavigationController
import com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.domain.model.TodoEditModel
import com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.domain.usecase.ReadTodoUseCase
import com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.domain.usecase.WriteTodoUseCase


/*
    ViewModel
    View上の要素（ボタンなど）をクリックした際の処理やデータモデル（Model）のやり取り、Viewへの反映を行う
*/

class TodoEditViewModel(
    private val readTodoUseCase: ReadTodoUseCase,
    private val writeTodoUseCase: WriteTodoUseCase,
    private val navigationController: NavigationController
): BaseObservable() {
    @get:Bindable
    var text: String = ""
        @Bindable set(text) {
            field = text
            notifyPropertyChanged(BR.text)
        }

    fun configure() {
        text = readTodoUseCase().text
    }

    fun onSave() {
        println("save ${this.text}")
        writeTodoUseCase(text)
        navigationController.closeActivity()
    }

    fun onClear() {
        text = ""
    }

    private fun readTodoUseCase(): TodoEditModel {
        return readTodoUseCase.execute()
    }

    private fun writeTodoUseCase(text: String) {
        writeTodoUseCase.execute(TodoEditModel(text))
    }
}