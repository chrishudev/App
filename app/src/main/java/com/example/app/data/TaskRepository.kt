package com.example.app.data

import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    // GET -- all TaskEntities from data source
    fun getAllItemsStream(): Flow<List<TaskEntity>>
    // GET -- all TaskEntities from data source where TaskEntity.id = id
    fun getItemStream(id: Int): Flow<TaskEntity?>
    // INSERT -- insert TaskEntity into data source
    suspend fun insertItem(item: TaskEntity)
    // DELETE -- delete TaskEntity from data source
    suspend fun deleteItem(item: TaskEntity)
    // UPDATE -- update TaskEntity in data source
    suspend fun updateItem(item: TaskEntity)
}