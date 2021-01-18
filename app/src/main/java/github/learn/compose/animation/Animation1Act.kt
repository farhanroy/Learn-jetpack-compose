package github.learn.compose.animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.*
import androidx.compose.animation.transition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class Animation1Act: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // SetContent can be used in the activity and fragment
        // this extension use to set sets the @Composable function
        // typically set using the setContent(R.id.xml_file) method. The setContent
        // block defines the activity's layout.
        setContent {
            RotateComponent()
        }
    }

    /**
     * PropKey using to hold animation in jetpack compose they will update by the animation
     * transition. the prop key like prop in react or livedata in android native programming
     * but in here, specially using for animation. You can add label to labeling prop key
     */
    private val rotation = FloatPropKey(label = "animation")

    /**
     * Transition Definition is definition of your transitions components.
     * Let’s understand the entire process of creating an animation in Jetpack Compose
     * using an example. In the following code snippet, we have created a [Transition Definition].
     */
    private val rotationTransitionDefinition = transitionDefinition<String> {

        // We defined state A in position 0 and state B in position 360. that meant, component
        // will circle rotation from 0 level to 360 level
        state("A") { this[rotation] = 0f }
        state("B") { this[rotation] = 360f }

        // In TransitionSpec we will specify the transition action. In here,
        // we will make transition from state "A" to "B"
        transition(fromState = "A", toState = "B") {
            // For the transition from state A -> state B, we assign a AnimationBuilder
            // we define AnimationBuilder with rotation. The duration for animation should be and
            // how many iteration is needed. Here, i using [infiniteRepeatable] to infinite repeating
            // component
            rotation using infiniteRepeatable(
                    animation = tween<Float>(
                            durationMillis = 3000,
                            easing = FastOutLinearInEasing
                    )
            )
        }
    }

    @Composable
    private fun RotateComponent() {
        // A layout composable that places its children in a vertical sequence
        // The Column layout is able to assign children heights according to
        // their weights provided using the ColumnScope.weight modifier
        Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {

                    //
                    val state = transition(
                            definition = rotationTransitionDefinition,
                            initState = "A",
                            toState = "B"
                    )

                    Canvas(modifier = Modifier.preferredSize(200.dp)) {
                        // As the Transition is changing the interpolating the value of your props based
                        // on the "from state" and the "to state", you get access to all the values
                        // including the intermediate values as they are being updated. We can use the
                        // state variable and access the relevant props/properties to update the relevant
                        // composables/layouts. Below, we use state[rotation] to get the latest value of
                        // rotation (it will be a value between 0 & 360 depending on where it is in the
                        // transition) and use it to rotate our canvas.
                        rotate(state[rotation]) {
                            drawRect(color = Color(255, 0, 0))
                        }
                    }
                }
        )
    }
}