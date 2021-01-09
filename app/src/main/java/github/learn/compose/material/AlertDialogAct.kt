package github.learn.compose.material

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent

/*
* How to display Alert Dialog in Android Jetpack Compose
*/
class AlertDialogAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // This code to centering text or another composable widget like as button, image
            // and others. Basically, Column displaying content horizontally. To display content
            // vertically you can use Row
            Column(
                    // Make the column fill the whole screen space (width and height).
                    modifier = Modifier.fillMaxSize(),
                    // Place all children at center horizontally.
                    verticalArrangement = Arrangement.Center,
                    // Place all children at center vertically.
                    horizontalAlignment = Alignment.CenterHorizontally,
                    content = {
                        // Call composable function to display it
                        ButtonAlert()
                    }
            )
        }
    }

    @Composable
    fun ButtonAlert() {
        // This is state. State will manage when alert showing or not. setShowDialog make action
        // to dialog and showDialog will listen dialog status
        val (showDialog, setShowDialog) = remember { mutableStateOf(false) }

        // This is Composable Widget Button to display alert dialog. Button have some property like
        // using xml layout. one of the property is onClick. onClick will listening button when get
        // an action, the function will be running
        Button(
                onClick = { setShowDialog(true) }) {
            // Button content text
            Text("Show Dialog")
        }
        // Create alert dialog, pass the showDialog state to this Composable
        DialogAlert(showDialog, setShowDialog)
    }

    @Composable
    fun DialogAlert(showDialog: Boolean, setShowDialog: (Boolean) -> Unit) {
        // When showDialog is true
        if (showDialog) {
            // AlertDialog is Composable widget from compose library
            AlertDialog(
                    // Action when dialog dismissed
                    onDismissRequest = {
                    },
                    // Dialog title
                    title = {
                        Text("Title")
                    },
                    // Dialog text content
                    text = {
                        Text("This is a text on the dialog")
                    },
                    // Confirm action
                    confirmButton = {
                        Button(
                                onClick = {
                                    // Change the state to close the dialog
                                    setShowDialog(false)
                                },
                        ) {
                            Text("Confirm")
                        }
                    },
                    // Cancel dialog
                    dismissButton = {
                        Button(
                                onClick = {
                                    // Change the state to close the dialog
                                    setShowDialog(false)
                                },
                        ) {
                            Text("Dismiss")
                        }
                    },
            )
        }
    }
}