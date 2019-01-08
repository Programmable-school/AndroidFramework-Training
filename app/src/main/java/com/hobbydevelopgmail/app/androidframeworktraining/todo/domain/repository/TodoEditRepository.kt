package com.hobbydevelopgmail.app.androidframeworktraining.todo.domain.repository

import com.hobbydevelopgmail.app.androidframeworktraining.todo.domain.model.TodoEditModel

interface TodoEditRepository {
    fun readTodoEditModel(): TodoEditModel
    fun writeTodoEditModel(todoEditModel: TodoEditModel)
}