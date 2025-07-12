package com.example.jet_2_app.view.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jet_2_app.R


@Composable
fun ProfileScreen(navController: NavHostController) {

    Column(modifier = Modifier.fillMaxSize().background(Color(0xFF1C1E21))) {
        ProfileTopAppBarFiled(navController)
        ProfiileImageandFollwersTextFiled(navController)




    }

}

@Composable
fun ProfiileImageandFollwersTextFiled(x0: NavHostController) {
    Column() {
        Row {
            Card(modifier = Modifier.padding(20.dp),
                shape = CircleShape,
//                elevation = CardElevation.d

            ){


            }
        }
    }
}

@Composable
fun ProfileTopAppBarFiled(navController: NavHostController) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Profile", textAlign = TextAlign.Center
             , color = Color.White, style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        ))

        Spacer(modifier = Modifier.weight(1f)) // Spacer to push the text to the left


        Image(painter = painterResource(R.drawable.outline_settings_24,), colorFilter =ColorFilter.tint(Color.White)
            , contentDescription = "")

    }
}