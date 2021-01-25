package github.learn.compose.core.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.emptyContent
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Center(composable: @Composable () -> Unit = emptyContent()) {
    // This code to centering text or another composable widget like as button, image
    // and others. Basically, Column displaying content horizontally. To display content
    // vertically you can use Row
    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = { composable() }
    )
}