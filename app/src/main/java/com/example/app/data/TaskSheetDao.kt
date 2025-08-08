package com.example.app.data

import android.content.ClipData.Item
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.app.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskSheetDao {
    // DAO interface for task sheet
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Task)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from tasks WHERE id = :id")
    fun getItem(id: Int): Flow<Task>

    @Query("SELECT * from tasks ORDER BY id ASC")
    fun getAllItems(): Flow<List<Task>>
}