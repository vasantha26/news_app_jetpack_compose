package com.example.jet_2_app.view.onboaring

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jet_2_app.R
import com.example.jet_2_app.routes.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(Unit) {
        delay(2000)
//        navController.navigate(Routes.MainRoute.OnboardingPager.route) {
//            popUpTo(Routes.MainRoute.Splash.route) {
//                inclusive = true
//            }
//        }
        navController.navigate(Routes.MainRoute.Login.route) {
            popUpTo(Routes.MainRoute.Splash.route) {
                inclusive = true
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(Color(0xFF1E88E5)),
        contentAlignment = Alignment.Center){
        Text(text = "News App", fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
        Image(painter = painterResource(id = R.drawable.world_news), contentDescription = "Splash")

    }
}