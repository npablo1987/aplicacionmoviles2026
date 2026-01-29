package com.example.semana1pv.ui.componentes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.example.semana1pv.R
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LottieAnimation (
    modifier: Modifier = Modifier,
    isPlaying: Boolean = true,
    iterations: Int = Int.MAX_VALUE,
){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying,
        iterations = iterations,
        speed = 1f
    )

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.size(400.dp)
        )

    }
}