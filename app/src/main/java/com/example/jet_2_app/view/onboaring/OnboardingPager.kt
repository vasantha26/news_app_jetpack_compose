package com.example.jet_2_app.view.onboaring

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.jet_2_app.R
import com.example.jet_2_app.model.OnboardingPage

val onboardingPages = listOf(
    OnboardingPage(R.drawable.news_img1, "Welcome", "This is the first onboarding screen."),
    OnboardingPage(R.drawable.news_img1, "Discover", "Learn more about what we offer."),
    OnboardingPage(R.drawable.news_img1, "Get Started", "Let's begin the journey!")
)

@Composable
fun OnboardingPager(navController: NavHostController) {
    var currentPage by remember { mutableIntStateOf(0) }
    val totalPages: Int = onboardingPages.size

    OnboardingScreen(
        navController = navController,
        page = onboardingPages[currentPage],
        currentPage = currentPage,
        totalPages = totalPages,
        onNextClick = {

            if (currentPage < totalPages - 1) currentPage++
        },
        onBackClick = {
            if (currentPage > 0) currentPage--
        }
    )
}

