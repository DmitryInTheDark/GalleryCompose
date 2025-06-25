package com.example.gallerycompose.ui.screens.main_screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.gallerycompose.R
import com.example.gallerycompose.ui.theme.BlueLight

@Composable
fun MakeScreen(navController: NavController){

    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize().background(Color.White), contentAlignment = Alignment.Center){
        Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.1f).background(Color.White),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {
            Button(colors = ButtonDefaults.buttonColors(BlueLight),
                onClick = {Toast.makeText(context, "Вылезло разрешение, галерея", Toast.LENGTH_SHORT).show()}) {
                Column(modifier = Modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly) {
                    Icon(painter = painterResource(R.drawable.folder_icon),
                        contentDescription = "Gallery")
                    Text(text = "Select Gallery")
                }

            }
            Button(colors = ButtonDefaults.buttonColors(BlueLight),
                onClick = { navController.navigate("makePhoto")}) {
                Column(modifier = Modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly) {
                    Icon(painter = painterResource(R.drawable.camera_icon),
                        contentDescription = "Camera")
                    Text(text = "Take a Photo")
                }
            }
        }
    }


}