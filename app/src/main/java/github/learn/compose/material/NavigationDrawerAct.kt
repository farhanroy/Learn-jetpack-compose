package github.learn.compose.material

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.*
import github.learn.compose.core.components.Center

class NavigationDrawerAct : AppCompatActivity() {

    private val ALL_SCREENS = listOf(AppScreen.TextTutorial, AppScreen.AwesomeButton)
    private val SCREEN_MAP = ALL_SCREENS.associateBy { it.route }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
            val navController = rememberNavController()

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

            Scaffold(
                    topBar = {
                        TopAppBar(title = { Text("Learn Jetpack Compose") }, navigationIcon = {
                            Icon(
                                    Icons.Default.Menu,
                                    modifier = Modifier.clickable(onClick = {
                                        scaffoldState.drawerState.open()
                                    })
                            )
                        })
                    },
                    drawerContent = {
                        Text(text = "List", style = MaterialTheme.typography.h5, modifier = Modifier.padding(16.dp))
                        ALL_SCREENS.forEach { screen ->
                            DrawerRow(
                                    title = screen.title,
                                    selected = currentRoute == screen.route,
                                    onClick = {
                                        // This is the equivalent to popUpTo the start destination
                                        navController.popBackStack(navController.graph.startDestination, false)

                                        // This if check gives us a "singleTop" behavior where we do not create a
                                        // second instance of the composable if we are already on that destination
                                        if (currentRoute != screen.route) {
                                            navController.navigate(screen.route)
                                        }

                                        scaffoldState.drawerState.close()
                                    })
                        }
                    },
                    scaffoldState = scaffoldState
            ) {
                NavHost(navController = navController, startDestination = AppScreen.TextTutorial.route) {
                    ALL_SCREENS.forEach { composable(it.route, content = it.content) }
                }
            }
        }

    }

    @Composable
    private fun DrawerRow(title: String, selected: Boolean, onClick: () -> Unit) {
        val background = if (selected) MaterialTheme.colors.primary.copy(alpha = 0.12f) else Color.Transparent
        val textColor = if (selected) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface
        ListItem(modifier = Modifier.clickable(onClick = onClick).background(background)) {
            Text(color = textColor, text = title)
        }
    }

    private sealed class AppScreen(val route: String, val title: String, val content: @Composable (backStackEntry: NavBackStackEntry) -> Unit) {
        object TextTutorial: AppScreen("components", "Text Tutorials", { backStackEntry -> TextPage(backStackEntry) })
        object AwesomeButton: AppScreen("buttons", "Awesome Button", { backStackEntry -> AwesomeButton(backStackEntry) })
    }

}

@Composable
private fun TextPage(backStackEntry: NavBackStackEntry) {
    Center{ Text("Here some text !") }
}

@Composable
private fun AwesomeButton(backStackEntry: NavBackStackEntry) {
    Center{ Button(onClick = { /*TODO*/ }) {
        Text(text = "Click me")
    } }
}