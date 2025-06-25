package com.example.gallerycompose.ui.screens.main_screens.bottom_nav_items

import com.example.gallerycompose.R

sealed class BottomItem(val icon: Int, val title: String, val route: String){
    object Home: BottomItem(R.drawable.home_icon, "Home", "home")
    object Make: BottomItem(R.drawable.make_icon, "Make", "make")
    object Profile: BottomItem(R.drawable.profile_icon, "Profile", "profile")
}