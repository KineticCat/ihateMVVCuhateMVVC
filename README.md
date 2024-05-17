# Final: To-Do App

basic to-do application, compose UI + ROOM DB


## Features

The Android app lets you:
- Create & Update tasks with a title, due date and completion status.
- Order tasks by their due date or completion status.
- Delete all completed tasks on single click.

## Tech stack
- Minimum SDK level 24
- [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- Dagger-Hilt for dependency injection.
- JetPack
    - State - Notify domain layer data to views.
    - Flows - To emit and collect UI state changes.
    - Lifecycle - Dispose of observing data when the lifecycle state changes.
    - ViewModel - UI-related data holder, lifecycle aware.
    - [Compose](https://developer.android.com/jetpack/compose) - Render UI.
- Architecture
    - MVVM Architecture (Model - View - ViewModel)
    - Repository pattern
    - data ~ domain ~ presentation
- [Room Database](https://developer.android.com/jetpack/androidx/releases/room) - For offline caching of data
