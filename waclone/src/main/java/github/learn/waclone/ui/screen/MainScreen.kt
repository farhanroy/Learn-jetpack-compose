package github.learn.waclone.ui.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import github.learn.waclone.route.BottomNavigationRoutes
import github.learn.waclone.ui.component.WaCloneBottomNavigation

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val bottomNavigationItems = listOf(
        BottomNavigationRoutes.Chat,
        BottomNavigationRoutes.People,
    )

    Scaffold(
        bottomBar = {
            WaCloneBottomNavigation(navController, bottomNavigationItems)
        },
    ) {
        NavHost(navController, startDestination = BottomNavigationRoutes.Chat) {
            composable(Screen.Profile.route) { Profile(navController) }
            composable(Screen.FriendsList.route) { FriendsList(navController) }
        }
    }
}