package com.example.gallerycompose.ui.screens.main_screens.details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gallerycompose.R


@Composable
fun DetailScreen(navController: NavController, image: Int, title: String, description: String, author: String){
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomStart){
            IconButton(onClick = { navController.popBackStack() },
                ){
                Icon(painter = painterResource(R.drawable.arrow_back), contentDescription = "back")
            }
        }

        Image(modifier = Modifier.fillMaxWidth().padding(20.dp).fillMaxHeight(0.5f)
            .clip(RoundedCornerShape(10.dp)),
            painter = painterResource(image),
            contentDescription = "ImageDetails",
            contentScale = ContentScale.FillBounds)

        Text(modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp ),
            text = title, fontSize = 40.sp, maxLines = 1)
        Text(modifier = Modifier.fillMaxWidth().padding(top = 20.dp, start = 20.dp, end = 20.dp),
            text = author, fontSize = 20.sp, color = Color.Gray)

        LazyColumn(modifier = Modifier.fillMaxSize().padding(20.dp)) {
            item(description) {
                Text(modifier = Modifier.fillMaxSize(),
                text = description, fontSize = 20.sp)
            }
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview(){
    val navController = rememberNavController()
    DetailScreen(navController, R.drawable.default_image, "Image Title", "description", "Author Name")
}
