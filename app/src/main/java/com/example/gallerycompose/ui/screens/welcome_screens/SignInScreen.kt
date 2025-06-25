package com.example.gallerycompose.ui.screens.welcome_screens.sign_in_screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gallerycompose.ui.theme.BlueLight


@Composable
fun SignInScreen(navController: NavController){

    val context = LocalContext.current
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()
        .background(Color.White).padding(top = 40.dp, start = 20.dp, end = 20.dp)) {

        Text(modifier = Modifier,
            text = "Sign In",
            style = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.Bold))

        Text(modifier = Modifier.padding(top = 25.dp, bottom = 10.dp),
            text = "Email",
            style = TextStyle(fontSize = 20.sp))

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = emailValue,
            onValueChange = {emailValue = it},
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                showKeyboardOnFocus = true
            ),
            singleLine = true
        )

        Text(modifier = Modifier.padding(top = 25.dp, bottom = 10.dp),
            text = "Password",
            style = TextStyle(fontSize = 20.sp))

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = passwordValue,
            onValueChange = {passwordValue = it},
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                showKeyboardOnFocus = true
            ),
            singleLine = true
        )

        Text(modifier = Modifier.fillMaxWidth()
            .padding(top = 10.dp).clickable(indication = null, interactionSource = remember { MutableInteractionSource() }){
                Toast.makeText(context, "Работает, кликается", Toast.LENGTH_SHORT).show()
            },
            text = "Forgot password?",
            textAlign = TextAlign.End,
            fontSize = 20.sp
        )

        Button(modifier = Modifier.fillMaxWidth().padding(top = 40.dp).height(50.dp),
            onClick = {
                navController.navigate("main")
            },
            colors = ButtonDefaults.buttonColors(BlueLight),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Sign In", fontSize = 20.sp)
        }

        Row(modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            Text(modifier = Modifier.padding(end = 5.dp),
                text = "Don`t have an account?",
                fontSize = 16.sp)
            Text(modifier = Modifier.clickable(indication = null,
                interactionSource = remember { MutableInteractionSource() }){
                Toast.makeText(context, "И это тоже кликается", Toast.LENGTH_SHORT).show()
            },
                text = "Sign Up", color = BlueLight, fontSize = 16.sp)
        }

    }
}