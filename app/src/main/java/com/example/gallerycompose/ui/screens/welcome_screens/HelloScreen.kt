package com.example.gallerycompose.ui.screens.welcome_screens.hello_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gallerycompose.R
import com.example.gallerycompose.ui.theme.BlueLight

@Composable
fun HelloScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize().background(Color.White)){
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.8f)){

            Column(modifier = Modifier.fillMaxSize().padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Image(modifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.23f),
                    painter = painterResource(R.drawable.hello_image),
                    contentDescription = "Hello")
                Text(modifier = Modifier.padding(top = 30.dp),
                    text = "Welcome",
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold))
                Text(modifier = Modifier.padding(top = 30.dp).fillMaxWidth(0.7f),
                    text = "Discover and share your best photos",
                    style = TextStyle(
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    ))
            }
        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
            Button(onClick = {
                navController.navigate("signIn")
            },
                modifier = Modifier.fillMaxWidth(0.8f)
                    .padding(bottom = 30.dp),
                colors = ButtonDefaults.buttonColors(BlueLight),
                shape = RoundedCornerShape(10.dp)
            ) {Text(text = "Get Started", style = TextStyle(
                color = Color.White,
                fontSize = 28.sp))}
        }
    }
}