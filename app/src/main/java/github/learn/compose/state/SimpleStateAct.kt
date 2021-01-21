package github.learn.compose.state

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Here, the simply example about how to managing state in jetpack compose
 * like hooks in react-native and bloc in flutter, jetpack compose currently have
 * state management to managing UI state. In This code i using [ remember ] to create internal
 * state in a composable. Look below of code
 */
object SimpleState {

    @Composable
    fun Page(vm: SimpleStateVM = viewModel()) {

        // this is counter state. the state will be increment automatically when any some action
        val counter: State<Int> =  vm.counter.observeAsState(0)

        Scaffold(
            topBar = { TopAppBar(
                title = { Text("Simple State", color = Color.White) },
                backgroundColor = Color.Black
            ) }
        ) {
            Column {
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
                        // Text to display counter state value
                        Text("Counter: ${counter.value}", fontSize = 32.sp)

                        // Spacer to make space between compoent
                        Spacer(modifier = Modifier.height(8.dp))

                        // Button increment state
                        Button(onClick = { vm.onValueChanged(counter.value + 1) }) {
                            Row {
                                Text("Add", Modifier.padding(end = 4.dp))
                                Icon(imageVector = Icons.Filled.Add)
                            }
                        }
                    }
                )
            }
        }
    }
}

// Stateful
class SimpleStateVM : ViewModel() {

    // LiveData holds state which is observed by the UI
    // (state flows down from ViewModel)
    private val _counter = MutableLiveData(0)
    val counter: LiveData<Int> = _counter

    // onNameChanged is an event we're defining that the UI can invoke
    // (events flow up from UI)
    fun onValueChanged(newCounter: Int) {
        _counter.value = newCounter
    }
}