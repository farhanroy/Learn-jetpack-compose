package github.learn.waclone.route

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.ui.graphics.vector.ImageVector
import github.learn.waclone.R

sealed class BottomNavigationRoutes(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Chat : BottomNavigationRoutes("Chat", R.string.chat_route, Icons.Outlined.Phone)
    object People : BottomNavigationRoutes("People", R.string.people_route, Icons.Filled.Person)
}