package com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.domain.repository

import com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.domain.model.TodoEditModel

interface TodoEditRepository {
    fun readTodoEditModel(): TodoEditModel
    fun writeTodoEditModel(todoEditModel: TodoEditModel)
}