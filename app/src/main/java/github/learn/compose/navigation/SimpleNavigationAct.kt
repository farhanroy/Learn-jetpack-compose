package github.learn.compose.navigation

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.navigation.NavController
import androidx.navigation.compose.*
import github.learn.compose.R
import github.learn.compose.core.components.Center

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object ScreenRoute1 : Screen("screen1", R.string.screen1)
    object ScreenRoute2 : Screen("screen2", R.string.screen2)
}

class SimpleNavigationAct: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleNavigation()
        }
    }

    @Composable
    fun SimpleNavigation() {
        val navController = rememberNavController()

        Scaffold() {
            NavHost(navController, startDestination = Screen.ScreenRoute1.route) {
                composable(Screen.ScreenRoute1.route) { Screen1(navController) }
                composable(Screen.ScreenRoute2.route) { Screen2(navController) }
            }

            Screen1(navController = navController)
        }
    }

    @Composable
    fun Screen1(navController: NavController){
        Center(composable = {
            Button(onClick = {
                // navigate to next screen
                navController.navigate(Screen.ScreenRoute1.route)
            }) {

                Text("Next")
            }
        })
    }

    @Composable
    fun Screen2(navController: NavController){
        Center {
            Text("Screen 2")
        }
    }
}