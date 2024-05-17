package com.swiftlover228.composed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.firebase.auth.FirebaseAuth
import com.swiftlover228.composed.ui.tasks.TasksScreen
import com.swiftlover228.composed.ui.theme.TasksToDoComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            TasksToDoComposeTheme {
                val auth = FirebaseAuth.getInstance()
                val taskViewModel: TasksViewModel = hiltViewModel()
                var showLoginScreen by remember { mutableStateOf(auth.currentUser == null) }
                var showSignupScreen by remember { mutableStateOf(false) }

                if (showLoginScreen) {
                    if (showSignupScreen) {
                        SignupScreen(
                            onSignupSuccess = {
                                showSignupScreen = false
                                showLoginScreen = false
                            }
                        )
                    } else {
                        LoginScreen(
                            onLoginSuccess = { showLoginScreen = true },
                            onNavigateToSignup = { showSignupScreen = true }
                        )
                    }
                } else {
                    val allTasks by taskViewModel.allTasks.collectAsState()
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        TasksScreen(
                            allTasks,
                            onSortClick = taskViewModel::getData,
                            onSaveTask = taskViewModel::addTask,
                            onUpdateTask = taskViewModel::updateTask,
                            onDeleteCompletedTasks = taskViewModel::deleteCompletedTasks,

                        )
                    }
                }
            }
        }
    }
}
