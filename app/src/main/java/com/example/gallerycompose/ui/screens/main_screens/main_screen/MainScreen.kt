package com.example.gallerycompose.ui.screens.main_screens.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.isDebugInspectorInfoEnabled
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gallerycompose.ui.screens.main_screens.HomeScreen
import com.example.gallerycompose.ui.screens.main_screens.MakeScreen
import com.example.gallerycompose.ui.screens.main_screens.ProfileScreen
import com.example.gallerycompose.ui.screens.main_screens.details_screen.DetailScreen
import com.example.gallerycompose.ui.screens.main_screens.make_screen.MakePhotoScreen
import com.example.gallerycompose.ui.screens.main_screens.profile_screen.EditProfileScreen
import com.example.gallerycompose.ui.screens.welcome_screens.splash_screen.SplashScreen

@Composable
fun MainScreen(navController: NavController){

    val mainNavController = rememberNavController()

    //Текущий Destination
    val currentDestination = mainNavController.currentBackStackEntryAsState().value?.destination?.route

    //NavHost основных экранов
    Scaffold(
        modifier = Modifier.fillMaxSize().background(Color.White),
        bottomBar = { MainBottomNavBar(mainNavController) }
    ) {padding ->
        NavHost(
            navController = mainNavController,
            startDestination = "home",
            modifier = Modifier.background(Color.White).padding(padding)){
            composable(route = "home") {
                HomeScreen(mainNavController)
            }
            composable(route = "make") {
                MakeScreen(mainNavController)
            }
            composable(route = "profile") {
                ProfileScreen(mainNavController)
            }
            composable(route = "details/{title}/{author}/{description}/{image}"){ backStackEntry ->
                //Получение аргументов из BackStack для DetailScreen
                val image = backStackEntry.arguments?.getString("image")?.toIntOrNull() ?: return@composable
                val title = backStackEntry.arguments?.getString("title") ?: ""
                val author = backStackEntry.arguments?.getString("author") ?: ""
                val description = backStackEntry.arguments?.getString("description") ?: ""

                DetailScreen(navController = mainNavController,
                    image = image, title = title,
                    description = description, author = author)
            }

            composable(route = "makePhoto") {
                MakePhotoScreen()
            }

            composable(route = "editProfile") {
                EditProfileScreen(mainNavController)
            }

            composable(route = "appStart") {
                navController.navigate("splash")
            }
        }
    }
}