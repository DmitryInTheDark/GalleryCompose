package com.example.gallerycompose.ui.screens.welcome_screens.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.gallerycompose.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){

    LaunchedEffect(Unit) {
        delay(2500)
        navController.navigate("hello")
    }

    Box(modifier = Modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center){
        Image(modifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.5f),
            painter = painterResource(R.drawable.splash_image),
            contentDescription = "SplashImage")
    }
}
