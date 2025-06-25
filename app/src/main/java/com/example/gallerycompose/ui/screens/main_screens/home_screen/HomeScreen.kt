package com.example.gallerycompose.ui.screens.main_screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gallerycompose.R
import com.example.gallerycompose.ui.screens.main_screens.home_screen.ListItem

@Composable
fun HomeScreen(navController: NavController) {

    val context = LocalContext.current

    //State для TextField поиска
    var queryValue by remember { mutableStateOf("") }

    //Список чисто для примера, логика отображения всё равно пока что будет на костлях
    val itemList = listOf(
        ListItem(R.drawable.default_big_image, "title", "author", "description"),
        ListItem(R.drawable.default_image, "title", "author", "description"),
        ListItem(R.drawable.default_image, "title", "author", "description"),
        ListItem(R.drawable.default_big_image, "title", "author", "description"),
        ListItem(R.drawable.default_image, "title", "author", "description"),
        ListItem(R.drawable.default_image, "title", "author", "description"),
        ListItem(R.drawable.default_big_image, "title", "author", "description"),
        ListItem(R.drawable.default_image, "title", "author", "description"),
        ListItem(R.drawable.default_image, "title", "author", "description"),
        ListItem(R.drawable.default_big_image, "title", "author", "description"),
        ListItem(R.drawable.default_image, "title", "author", "description"),
        ListItem(R.drawable.default_image, "title", "author", "description"),
    )

    val chunkedImageList = itemList.chunked(3)

    Column(modifier = Modifier.fillMaxSize().padding(20.dp).background(Color.White)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Home", fontSize = 36.sp, fontWeight = FontWeight.Bold)
            Icon(
                modifier = Modifier.height(40.dp).width(40.dp),
                painter = painterResource(R.drawable.search_icon),
                contentDescription = "search"
            )
        }
        TextField(
            modifier = Modifier.fillMaxWidth().padding(top = 15.dp)
                .clickable {
                Toast.makeText(context, chunkedImageList.joinToString(), Toast.LENGTH_SHORT).show()
            },
            value = queryValue,
            onValueChange = { queryValue = it },
            shape = RoundedCornerShape(10.dp),
            leadingIcon = {
                Icon(
                    modifier = Modifier.width(30.dp).height(30.dp),
                    painter = painterResource(R.drawable.search_icon),
                    contentDescription = "searchTextField"
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            label = { Text(text = "Search", fontSize = 18.sp) },
            singleLine = true
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items = chunkedImageList) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        modifier = Modifier.fillMaxWidth().clickable {
                            navController.navigate("details/${it[0].title}/${it[0].author}/${it[0].description}/${it[0].image}")
                        }.padding(top = 20.dp, start = 20.dp, end = 20.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillBounds,
                        painter = painterResource(it[0].image), contentDescription = "bigImage"
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                    ) {
                        Image(
                            modifier = Modifier.fillMaxWidth(0.5f).padding(end = 10.dp).clickable {
                                navController.navigate("details/${it[1].title}/${it[1].author}/${it[1].description}/${it[1].image}")
                            }.clip(RoundedCornerShape(10.dp)),
                            painter = painterResource(it[1].image),
                            contentDescription = "smallImage1"
                        )
                        Image(
                            modifier = Modifier.fillMaxWidth().padding(start = 10.dp).clickable {
                                navController.navigate("details/${it[2].title}/${it[2].author}/${it[2].description}/${it[2].image}")
                            }.clip(RoundedCornerShape(10.dp)),
                            painter = painterResource(it[2].image),
                            contentDescription = "smallImage1"
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenpreview(){
    val navController = rememberNavController()

    HomeScreen(navController)
}