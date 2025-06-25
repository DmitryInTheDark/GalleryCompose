package com.example.gallerycompose.ui.screens.main_screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gallerycompose.R

@Composable
fun ProfileScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize().background(Color.White).padding(20.dp)) {
        Text(modifier = Modifier.fillMaxWidth(),
            text = "Profile", fontSize = 40.sp)
        Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.2f).padding(top = 20.dp)) {
            Image(modifier = Modifier.fillMaxWidth(0.3f).fillMaxHeight().clip(CircleShape),
                painter = painterResource(R.drawable.profile_standart_image),
                contentDescription = "ProfileImage",
                contentScale = ContentScale.Crop)
            Column(modifier = Modifier.fillMaxSize()) {
                Text(modifier = Modifier.fillMaxWidth().padding(20.dp),
                    text = "Name", fontSize = 40.sp, maxLines = 2)
                Text(modifier = Modifier.fillMaxWidth().padding(start = 20.dp),
                    text = "name@xample.com", maxLines = 1)
            }
        }
        Button(modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
            onClick = {navController.navigate("editProfile")}, border = BorderStroke(1.dp, color = Color.Gray),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White, ), shape = RectangleShape) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart){
                Text(text = "Edit Profile", fontSize = 30.sp, color = Color.Black)
            }
        }
        Button(modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
            onClick = {navController.navigate("appStart")}, border = BorderStroke(1.dp, color = Color.Gray),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White, ), shape = RectangleShape) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart){
                Text(text = "Sign Out", fontSize = 30.sp, color = Color.Black)
            }
        }
    }
}

@Preview
@Composable
fun ProfilePreview(){

    val navController = rememberNavController()

    ProfileScreen(navController)
}