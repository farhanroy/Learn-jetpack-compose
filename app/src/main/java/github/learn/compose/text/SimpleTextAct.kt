package github.learn.compose.text

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
/*
* Now, we will learn how to displaying text in jetpack compose
*/
class SimpleTextAct: AppCompatActivity() {
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // This code to centering text or another composable widget like as button, image
            // and others. Basically, Column displaying content horizontally. To display content
            // vertically you can use Row
            Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    content = {
                        SimpleText("Learning jetpack compose")
                    }
            )
        }
    }

    @Composable
    fun SimpleText(displayText: String) {
        // We should think of composable functions to be similar to lego blocks - each composable
        // function is in turn built up of smaller composable functions. Here, the Text() function is
        // pre-defined by the Compose UI library; you call that function to declare a text element
        // in your app.
        Text(text = displayText)
    }
}