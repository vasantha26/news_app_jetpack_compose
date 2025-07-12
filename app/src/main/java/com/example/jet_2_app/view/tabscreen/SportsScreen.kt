package com.example.jet_2_app.view.tabscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.jet_2_app.R
import com.example.jet_2_app.model.Articles
import com.example.jet_2_app.viewmodel.NewsViewModel

@Composable
fun SportsScreen(viewModel: NewsViewModel) {

    viewModel.fetchCategory("sports")

    val newsList by viewModel.newsResponseCategory.collectAsState()

    LazyColumn(modifier = Modifier.background(Color(0xFF1C1E21))) {
        items(newsList) { article ->
            NewsCardSports(article)
        }
    }
}

@Composable
fun NewsCardSports(article: Articles) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2A2D32)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            // Thumbnail Image
            Image(
                painter = rememberAsyncImagePainter(article.urlToImage),
                contentDescription = null,
                modifier = Modifier.size(80.dp).clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )


            Spacer(modifier = Modifier.width(12.dp))

            // Text Column
            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = article.source?.name ?: "World",
                    style = TextStyle(fontSize = 12.sp, color = Color.LightGray)
                )
                Text(
                    text = article.title ?: "",
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White),
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.news_img1),
                        contentDescription = "Source",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = article.author ?: "World",
                        style = TextStyle(fontSize = 12.sp,fontWeight = FontWeight.SemiBold, color = Color.White)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                }
            }
        }
    }
}