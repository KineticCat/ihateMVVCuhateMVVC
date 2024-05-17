package com.swiftlover228.composed.data

import com.swiftlover228.composed.data.db.dao.TaskDao
import com.swiftlover228.composed.data.db.entity.Task
import com.swiftlover228.composed.domain.TasksRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class TasksRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) : TasksRepository {

    override suspend fun addTask(task: Task) {
        taskDao.addTask(task)
    }

    override suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    override suspend fun deleteCompletedTasks() = taskDao.deleteCompletedTasks()

    override suspend fun getAllTasks(): Flow<List<Task>> = taskDao.getTasks()

    override suspend fun getAllTaskByDate(): Flow<List<Task>> = taskDao.getTasksByDate()

    override suspend fun getAllTaskByCompletion(): Flow<List<Task>> = taskDao.getTasksByCompletion()
}