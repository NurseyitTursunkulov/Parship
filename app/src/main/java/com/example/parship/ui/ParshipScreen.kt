package com.example.parship.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.parship.ButtonViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * Created by nurseiit.tursunkulov on 11.11.23.
 */

@Composable
fun ParshipScreen(viewModel: ButtonViewModel = koinViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        ParshipTitle(screenState = viewModel.screenState.collectAsStateWithLifecycle().value, modifier = Modifier.align(Alignment.Center))
        OutlinedButton(shape = RoundedCornerShape(20.dp), onClick = { viewModel.toggleText() }, modifier = Modifier.align(Alignment.BottomCenter)) {
            Text("Toggle")
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ParshipTitle(screenState: ScreenState, modifier: Modifier = Modifier) {
    AnimatedContent(targetState =screenState, label = "",modifier = modifier, transitionSpec = {
        fadeIn(animationSpec = tween(320, delayMillis = 90))  with
                fadeOut(animationSpec = tween(90))
    }) {screenStateAnimated->
        when (screenStateAnimated) {
            ScreenState.Parship -> ParshipText(
                text = screenStateAnimated.title,
                modifier = modifier,
                color = screenStateAnimated.color,
            )
            ScreenState.ElitePartner -> ParshipText(
                text = screenStateAnimated.title,
                modifier = modifier,
                color = screenStateAnimated.color,
            )
        }
    }
}
@Composable
private fun ParshipText(text:String,color:Color, modifier: Modifier = Modifier){
    Text(
        text = text,
        style = MaterialTheme.typography.displayLarge.copy(
            fontWeight = FontWeight.SemiBold,
        ),
        modifier = modifier,
        color = color
    )
}