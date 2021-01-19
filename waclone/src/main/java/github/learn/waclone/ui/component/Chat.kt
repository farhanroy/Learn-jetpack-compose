package github.learn.compose.waclone.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ChatPage() {

}

@Composable
fun ChatTopBar() {
    Row {
       Text(text = "Chats", fontWeight = FontWeight.Bold, ) 
    }
}

@Composable
fun SearchBox() {}

@Composable
fun ChatList() {}

