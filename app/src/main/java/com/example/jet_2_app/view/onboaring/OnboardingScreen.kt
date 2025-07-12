package com.example.jet_2_app.view.onboaring

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavHostController
import com.example.jet_2_app.model.OnboardingPage
import com.example.jet_2_app.routes.Routes


@Composable
fun OnboardingScreen(
    navController: NavHostController,
    page: OnboardingPage,
    currentPage: Int,
    totalPages: Int,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF1C1E21))
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Image(
                painter = painterResource(id = page.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(200.dp).width(200.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Text(text = page.title, fontSize = 22.sp, color = Color.White, fontWeight = FontWeight.Bold);
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = page.description, color = Color.White, fontWeight = FontWeight.Normal)
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Dots
            Row {
                repeat(totalPages) { index ->
                    Box(
                        modifier = Modifier
                            .size(if (index == currentPage) 12.dp else 8.dp)
                            .clip(CircleShape)
                            .background(if (index == currentPage) Color(0xFF3B82F6) else Color.LightGray)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

            // Buttons
            Row {
                if (currentPage > 0) {
                    TextButton(onClick = onBackClick) {
                        Text(
                            "Back",
                            color = Color.Red,
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                if (currentPage < totalPages - 1) {
                    Button(onClick = onNextClick) {
                        Text(
                            "Next",
                            color = Color.Blue,
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        )
                    }
                } else {
                    Button(onClick = {
                        // Navigate to home or other screen
                        navController.navigate(Routes.MainRoute.Login.route) {
                            popUpTo("onboarding") { inclusive = true }
                        }
                    }) {
                        Text(
                            "Get Started",
                            color = Color.Blue,
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }
        }

    }

}