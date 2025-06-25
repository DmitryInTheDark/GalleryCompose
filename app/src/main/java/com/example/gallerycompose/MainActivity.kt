package com.example.gallerycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gallerycompose.ui.screens.main_screens.main_screen.MainScreen
import com.example.gallerycompose.ui.screens.welcome_screens.hello_screen.HelloScreen
import com.example.gallerycompose.ui.screens.welcome_screens.sign_in_screen.SignInScreen
import com.example.gallerycompose.ui.screens.welcome_screens.splash_screen.SplashScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WelcomeNavHostScreen()
        }
    }

}

@Preview
@Composable
fun WelcomeNavHostScreen(){

    val WelcomeNavController = rememberNavController()

    //NavHost при запуске приложения
        NavHost(
            navController = WelcomeNavController,
            startDestination = "splash",
            modifier = Modifier.fillMaxSize().background(Color.White)
        ){
            composable(route = "splash") {
                SplashScreen(WelcomeNavController)
            }
            composable(route = "hello") {
                HelloScreen(WelcomeNavController)
            }
            composable(route = "signIn") {
                SignInScreen(WelcomeNavController)
            }
            composable(route = "main") {
                MainScreen(WelcomeNavController)
            }


        }

}
