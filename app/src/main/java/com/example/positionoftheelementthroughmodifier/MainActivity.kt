package com.example.positionoftheelementthroughmodifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import com.example.positionoftheelementthroughmodifier.ui.theme.PositionOfTheElementThroughModifierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            PositionOfTheElementThroughModifierTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    showShowCase(
                        showShowCase = true
                    ){
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(
                                onClick = {

                                },
                                modifier = Modifier.introShowCaseTarget(
                                    index = 1,
                                ){
                                    Text("hello click here for 1st button",
                                    color = Color.White
                                        )
                                }
                            ) {
                                Text(text = "button1")
                            }
                            Button(
                                onClick = {

                                },
                                modifier = Modifier.introShowCaseTarget(
                                    index = 2,
                                    style = ShowcaseStyle.Default.copy(
                                        backgroundColor = Color(0xFF7C99AC), // specify color of background
                                        backgroundAlpha = 0.6f, // specify transparency of background
                                        targetCircleColor = Color.White
                                    )
                                ){

                                }
                            ) {
                                Text(text = "button2")
                            }


                        }



                    }

                }
            }
        }
    }
}

//step - 1
@Composable
fun showShowCase(
     showShowCase:Boolean,
     // todo - pass the initial state object with index = 1
     state : IntroShowCaseState =   IntroShowCaseState(initialIndex = 1),

     IntroShowCaseScopeContent: @Composable IntroShowCaseScope.() -> Unit,

){

    //todo 1st initialize the showcaseObject with introShowcaseState(initialIndex = 1)  ,currentTargetIndex = 1 , target[1] = null
    val introShowCaseScope = remember(state){
        mutableStateOf(IntroShowCaseScope(state))
    }
    Box(modifier = Modifier.fillMaxSize()){
        //step - 2
        //todo this scope represents the boxScope in which we got our full main display  along with the IntroShowcase class methods in it
        introShowCaseScope.value.IntroShowCaseScopeContent()

        if (showShowCase) {
            //step-3
            //todo this is the showcase screen in our main display screen it takes the initial state
            IntroShowCase(
                state = state //IntroShowCaseState(initialIndex = 1),currentIndex = 1 ,target[1] = null
            )
        }
    }

}





data class IntroShowcaseTarget(
    val index: Int,
    val coordinates: LayoutCoordinates,
    val backgroundColor:Color = Color.Black,
    val backgroundAlpha:Float = 0.4f,
    val style: ShowcaseStyle = ShowcaseStyle.Default,
    val content: @Composable BoxScope.() -> Unit
)