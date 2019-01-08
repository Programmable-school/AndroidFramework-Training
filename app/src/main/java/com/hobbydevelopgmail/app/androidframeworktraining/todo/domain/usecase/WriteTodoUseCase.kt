package com.hobbydevelopgmail.app.androidframeworktraining.todo.domain.usecase

import com.hobbydevelopgmail.app.androidframeworktraining.todo.domain.model.TodoEditModel
import com.hobbydevelopgmail.app.androidframeworktraining.todo.domain.repository.TodoEditRepository

class WriteTodoUseCase(private val repository: TodoEditRepository) {
    fun execute(todoEditModel: TodoEditModel) {
        repository.writeTodoEditModel(todoEditModel)
    }
}