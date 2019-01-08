package com.hobbydevelopgmail.app.androidframeworktraining.todo.domain.usecase

import com.hobbydevelopgmail.app.androidframeworktraining.todo.domain.model.TodoEditModel
import com.hobbydevelopgmail.app.androidframeworktraining.todo.domain.repository.TodoEditRepository

class ReadTodoUseCase(private val repository: TodoEditRepository) {
    fun execute(): TodoEditModel {
        return repository.readTodoEditModel()
    }
}