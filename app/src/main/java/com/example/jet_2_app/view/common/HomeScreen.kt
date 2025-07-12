package com.example.jet_2_app.view.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.jet_2_app.R
import com.example.jet_2_app.view.tabscreen.AllScreen
import com.example.jet_2_app.view.tabscreen.BusinessScreen
import com.example.jet_2_app.view.tabscreen.HealthScreen
import com.example.jet_2_app.view.tabscreen.PoliticsScreen
import com.example.jet_2_app.view.tabscreen.ScienceScreen
import com.example.jet_2_app.view.tabscreen.SportsScreen
import com.example.jet_2_app.view.tabscreen.TravelScreen


@Composable
fun HomeScreen(navController: NavHostController) {



    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF1C1E21))

    ) {

        TopAppBarFiled(navController)

        SearchBarFiled(navController, onSearchBarChanged = { searchText ->}, onFliterChanged = { filter ->},)

//        TrandingTextFiled("Tranding",navController)

//        TrandingNewsName()

        TrandingTextFiled("Latest",navController)

        SimpleTabBar()


    }

}

@Composable
fun SimpleTabBar() {
    val tabs = listOf("All", "Sports", "Politics", "Business", "Health", "Travel", "Science")
    var selectTabIndex by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxWidth()) {
        ScrollableTabRow(
            selectedTabIndex = selectTabIndex,
            containerColor = Color.Black,
            contentColor = Color.White
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectTabIndex == index,
                    onClick = { selectTabIndex = index },
                    text = {
                        Text(
                            title,
                            color = if (selectTabIndex == index) Color.White else Color.White.copy(alpha = 0.6f)
                        )
                    }
                )
            }
        }

        when (selectTabIndex) {
            0 -> AllScreen(viewModel = viewModel())
            3 -> BusinessScreen(viewModel = viewModel())
            1 -> SportsScreen(viewModel = viewModel())
            2 -> PoliticsScreen(viewModel = viewModel())
            4 -> HealthScreen(viewModel = viewModel())
            5 -> TravelScreen(viewModel = viewModel())
            6 -> ScienceScreen(viewModel = viewModel())
        }
    }
}


@Composable
fun TrandingNewsName() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.background(Color(0xFF1C1E21))) {
            Image(
                painter = painterResource(R.drawable.news_img1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Name of the News",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row {
                    Text(
                        text = "Author: ",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                    Text(
                        text = "John Doe",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.baseline_newspaper_24),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color.White)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Source: ",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                    Text(
                        text = "The Times",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Image(
                        painter = painterResource(R.drawable.outline_more_horiz_24),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }
            }
        }
    }
}


@Composable
fun TrandingTextFiled(name: String, navController: NavHostController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            ),
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        ClickableText(
            text = AnnotatedString("See All"),
            onClick = {
                println("See All clicked!")
            },
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun SearchBarFiled(
    navHostController: NavHostController,
    onSearchBarChanged: (String) -> Unit,
    onFliterChanged: (String) -> Unit
) {

    var searchText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchText,
        onValueChange = {
            searchText = it
            onSearchBarChanged(it) },
        placeholder = { Text(text = "Search...") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "")
        },
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.LightGray
        )
    )
}

@Composable
fun TopAppBarFiled(navController: NavHostController) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "News App", color = Color.Blue, style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        ))

        Spacer(modifier = Modifier.weight(1f)) // Spacer to push the text to the left


        Image(painter = painterResource(R.drawable.outline_notifications_unread_24,), colorFilter =ColorFilter.tint(Color.White)
            , contentDescription = "")

    }
}




