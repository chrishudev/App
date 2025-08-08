package com.example.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey val id: Int,
    val title: String = "",
    val category: String = "",
    val body: String = ""
)