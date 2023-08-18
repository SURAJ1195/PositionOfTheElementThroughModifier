package com.example.positionoftheelementthroughmodifier

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

//part-3
//todo we have create a method for the  

class IntroShowCaseState internal constructor(
    initialIndex: Int, //1
) {

    //todo introShowcaseTarget represents the individual target or the (data class) state for each component
    //todo and the state of showcase represents or maps each component with according to its index with the  view.
    //todo so that this state must be singleton
    internal var targets = mutableStateMapOf<Int, IntroShowcaseTarget>()

    var currentTargetIndex by mutableStateOf(initialIndex)  //currentTargetIndex = 1
        internal set

    val currentTarget: IntroShowcaseTarget?
        get() = targets[currentTargetIndex]
}