package com.example.gallerycompose.ui.screens.main_screens.profile_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gallerycompose.ui.theme.BlueLight

@Composable
fun EditProfileScreen(navController: NavController){

    var nameValue by remember { mutableStateOf("") }
    var emailValue by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().background(Color.White).padding(20.dp)) {
        Text(modifier = Modifier.fillMaxWidth(),
            text = "Edit Profile", fontSize = 40.sp)

        Text(modifier = Modifier.fillMaxWidth().padding(top = 20.dp, bottom = 5.dp),
            text = "Name", fontSize = 24.sp)
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = nameValue,
            onValueChange = {nameValue = it},
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            maxLines = 2
        )
        Text(modifier = Modifier.fillMaxWidth().padding(top = 20.dp, bottom = 5.dp),
            text = "Email", fontSize = 24.sp)
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = emailValue,
            onValueChange = {emailValue = it},
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            maxLines = 2
        )

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
            Button(modifier = Modifier.fillMaxWidth(),
                onClick = {navController.popBackStack()},
                colors = ButtonDefaults.buttonColors(BlueLight),
                shape = RoundedCornerShape(10.dp)) {
                Text(text = "Save", fontSize = 24.sp)
            }
        }
    }
}