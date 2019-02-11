package com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.domain.usecase

import com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.domain.model.TodoEditModel
import com.hobbydevelopgmail.app.androidframeworktraining.other.cleanarchitecture.domain.repository.TodoEditRepository

class ReadTodoUseCase(private val repository: TodoEditRepository) {
    fun execute(): TodoEditModel {
        return repository.readTodoEditModel()
    }
}