package com.swiftlover228.composed.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.swiftlover228.composed.data.db.converter.Converters
import com.swiftlover228.composed.data.db.dao.TaskDao
import com.swiftlover228.composed.data.db.entity.Task


@Database(entities = [Task::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun getTaskDao(): TaskDao
}