package com.swiftlover228.composed.domain

import com.swiftlover228.composed.data.db.entity.Task
import kotlinx.coroutines.flow.Flow

interface TasksRepository {

    suspend fun addTask(task:Task)

    suspend fun updateTask(task: Task)

    suspend fun deleteCompletedTasks()

    suspend fun getAllTasks(): Flow<List<Task>>

    suspend fun getAllTaskByDate(): Flow<List<Task>>

    suspend fun getAllTaskByCompletion(): Flow<List<Task>>
}