package com.example.positionoftheelementthroughmodifier

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned

//step - 4
class IntroShowCaseScope(
    private val state: IntroShowCaseState, // IntroShowCaseState(initialIndex = 1) ,currentTargetIndex = 1 , target[1] = null
) {

    //step - 5
    fun Modifier.introShowCaseTarget(
        index: Int,  // 1
        style: ShowcaseStyle = ShowcaseStyle.Default,
        content: @Composable BoxScope.() -> Unit,
    ): Modifier
    {
        return introShowCaseTarget(
            state = state, // IntroShowCaseState(initialIndex = 1) ,currentTargetIndex = 1 ,target[1] = null
            index = index, // 1
             style = style,
            content = content,
        )
    }
}

//step - 6
fun Modifier.introShowCaseTarget(
    state: IntroShowCaseState, // IntroShowCaseState(initialIndex = 1) ,currentTargetIndex = 1 ,target[1] = null
    index: Int, //1
     style: ShowcaseStyle = ShowcaseStyle.Default,
    content: @Composable BoxScope.() -> Unit,
): Modifier {
    return onGloballyPositioned { coordinates ->

        // todo from here we got the cordinate and the  target[index] value
        //step - 7
        state.targets[index] = IntroShowcaseTarget(index = index, coordinates = coordinates,  style = style,
                                                        content = content)
    }
}