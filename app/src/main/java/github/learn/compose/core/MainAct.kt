package github.learn.compose.core

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import github.learn.compose.animation.Animation1Act
import github.learn.compose.material.AlertDialogAct
import github.learn.compose.material.NavigationDrawerAct
import github.learn.compose.navigation.SimpleNavigationAct
import github.learn.compose.text.SimpleTextAct

class MainAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Route
            toNavigationDrawer()
        }
    }


    fun toSimpleText() {
        startActivity(Intent(this, SimpleTextAct::class.java))
    }

    fun toAlertDialog() {
        startActivity(Intent(this, AlertDialogAct::class.java))
    }

    fun toAnimation1() {
        startActivity(Intent(this, Animation1Act::class.java))
    }

    fun toSimpleNavigation() {
        startActivity(Intent(this, SimpleNavigationAct::class.java))
    }

    fun toNavigationDrawer() {
        startActivity(Intent(this, NavigationDrawerAct::class.java))
    }
}