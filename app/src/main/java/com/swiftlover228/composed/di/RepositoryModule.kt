package com.swiftlover228.composed.di

import com.swiftlover228.composed.data.TasksRepositoryImpl
import com.swiftlover228.composed.domain.TasksRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTasksRepository(impl: TasksRepositoryImpl): TasksRepository
}