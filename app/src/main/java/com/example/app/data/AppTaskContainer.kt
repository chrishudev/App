package com.example.app.data

import android.content.Context

interface AppTaskContainer {
    val taskRepository: TaskRepository
} // FOR -- dependency injection

class AppTaskDataContainer(private val context: Context) : AppTaskContainer {
    override val taskRepository: TaskRepository by lazy {
        OfflineTaskRepository(TaskDatabase.getDatabase(context).taskDao())
    }
} // FOR -- implementation that provides offline
