package com.example.app.data

import kotlinx.coroutines.flow.Flow

class OfflineTaskRepository(private val taskDao: TaskDao): TaskRepository {
    override fun getAllItemsStream(): Flow<List<TaskEntity>> = taskDao.getAllItems()
    override fun getItemStream(id: Int): Flow<TaskEntity> = taskDao.getItem(id)
    override suspend fun insertItem(item: TaskEntity) = taskDao.insert(item)
    override suspend fun deleteItem(item: TaskEntity) = taskDao.delete(item)
    override suspend fun updateItem(item: TaskEntity) = taskDao.update(item)
}