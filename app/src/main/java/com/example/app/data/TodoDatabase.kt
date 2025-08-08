package com.example.app.data

import android.content.ClipData.Item
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.app.Task

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    // Database of DAO task objects
    abstract fun task(): Task
    companion object {
        @Volatile
        private var Instance: TaskDatabase? = null
        fun getDatabase(context: Context): TaskDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, TaskDatabase::class.java, "task_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}