package com.swiftlover228.composed.ui.tasks

import com.swiftlover228.composed.data.db.entity.Task

data class TasksState(
    val tasks: List<Task> = emptyList(),
    val sortType: SortType = SortType.Date
)

enum class SortType {
    Date, Completion
}
