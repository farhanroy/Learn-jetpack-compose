package github.learn.compose.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import github.learn.compose.core.components.Center

class SimpleNavigationAct: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleNavigation()
        }
    }

    @Composable
    fun SimpleNavigation() {

        val state = remember { AppState() }

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Learn Jetpack Compose")}, backgroundColor = Color.Green)
            },
        ) {
            BackPressHandler(appState = state)
        }
    }

    @Composable
    fun BackPressHandler(appState: AppState) {
        when (appState.currentScreen) {
            CurrentScreen.SCREEN1 -> Screen1(appState)
            CurrentScreen.SCREEN2 -> Screen2(appState)
        }
    }

    @Composable
    fun Screen1(appState: AppState){
        Center(composable = {
            Button(onClick = {
                // Navigate to next screen (SCREEN 2)
                appState.currentScreen = CurrentScreen.SCREEN2
            }) { Text("Next") }
        })
    }

    @Composable
    fun Screen2(appState: AppState){
        Center {
            Text("Screen 2")
        }
    }
}

// Simple class that we created to hold the value for the current active screen.
class AppState {
    var currentScreen by mutableStateOf(CurrentScreen.SCREEN1)
}

enum class CurrentScreen {
    SCREEN1,
    SCREEN2
}