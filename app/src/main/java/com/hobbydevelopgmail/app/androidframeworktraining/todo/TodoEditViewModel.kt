package com.hobbydevelopgmail.app.androidframeworktraining.todo

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.hobbydevelopgmail.app.androidframeworktraining.BR
import com.hobbydevelopgmail.app.androidframeworktraining.common.NavigationController


/*
    ViewModel
    View上の要素（ボタンなど）をクリックした際の処理やデータモデル（Model）のやり取り、Viewへの反映を行う
*/

class TodoEditViewModel(
    private val navigationController: NavigationController
): BaseObservable() {
    @get:Bindable
    var text: String = ""
        @Bindable set(text) {
            field = text
            notifyPropertyChanged(BR.text)
        }

    fun onSave() {
        println("save ${this.text}")
        navigationController.closeActivity()
    }

    fun onClear() {
        text = ""
    }
}