package com.example.app.data

import android.content.Context
import com.example.app.TaskDatabase

interface AppContainer {
    // App container for dependency injection
    val itemsRepository: TaskRepository
}

class TodoContainer {

}