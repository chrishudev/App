package com.example.app.data

import com.example.app.Task
import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Task] from a given data source.
 */
interface TaskRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllItemsStream(): Flow<Task?>
    /**
     * Insert item in the data source
     */
    suspend fun insertItem(item: Task)
    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(item: Task)
    /**
    * Update item in the data source
    */
    suspend fun updateItem(item: Task)
}