package com.example.app.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: TaskEntity)

    @Update
    suspend fun update(item: TaskEntity)

    @Delete
    suspend fun delete(item: TaskEntity)

    @Query("SELECT * from tasks WHERE id = :id")
    fun getItem(id: Int): Flow<TaskEntity>

    @Query("SELECT * from tasks ORDER BY id ASC")
    fun getAllItems(): Flow<List<TaskEntity>>
}