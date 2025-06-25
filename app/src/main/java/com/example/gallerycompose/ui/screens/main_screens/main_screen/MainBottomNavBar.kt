package com.example.gallerycompose.ui.screens.main_screens.main_screen

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gallerycompose.ui.screens.main_screens.bottom_nav_items.BottomItem


@Composable
fun MainBottomNavBar(
    navController: NavHostController
) {

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val bottomItemList = listOf(
        BottomItem.Home, BottomItem.Make, BottomItem.Profile
    )

    NavigationBar {
        bottomItemList.forEach {
            NavigationBarItem(
                selected = currentRoute == it.route,
                onClick = {
                    if (currentRoute != it.route){
                        navController.navigate(it.route){
                            popUpTo(navController.graph.startDestinationId){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = { Icon(painter = painterResource(it.icon), contentDescription = it.title)  },
                label = { Text(it.title) }
            )
        }
    }
}