package com.example.jet_2_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jet_2_app.routes.Routes
import com.example.jet_2_app.view.common.BookmarkScreen
import com.example.jet_2_app.view.common.ExploseScreen
import com.example.jet_2_app.view.common.HomeScreen
import com.example.jet_2_app.view.common.LandingScreen
import com.example.jet_2_app.view.common.ProfileScreen
import com.example.jet_2_app.view.login.ForgotPasswordScreen
import com.example.jet_2_app.view.login.LoginScreen
import com.example.jet_2_app.view.login.OtpVerificationScreen
import com.example.jet_2_app.view.login.SignUpScreen
import com.example.jet_2_app.view.onboaring.OnboardingPager
import com.example.jet_2_app.view.onboaring.SplashScreen


@Composable
fun MainNavigation() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = Routes.MainRoute.Splash.route){

        composable(Routes.MainRoute.Splash.route){
            SplashScreen(navController)
        }

        composable(Routes.MainRoute.OnboardingPager.route){
            OnboardingPager(navController)
        }
//        composable(Routes.MainRoute.Onboarding.route){
//            OnboardingScreen(navController)
//        }

        composable(Routes.MainRoute.Login.route){
            LoginScreen(navController)
        }

        composable(Routes.MainRoute.Home.route) {
            HomeScreen(navController)
        }

        composable(Routes.MainRoute.Landing.route) {
            LandingScreen(navController)
        }

        composable(Routes.MainRoute.Explose.route) {
            ExploseScreen(navController)
        }

        composable(Routes.MainRoute.Bookmark.route) {
            BookmarkScreen(navController)
        }

        composable(Routes.MainRoute.Profile.route) {
            ProfileScreen(navController)
        }

        composable(Routes.MainRoute.SignUP.route) {
            SignUpScreen(navController)
        }

        composable(Routes.MainRoute.ForgotPassword.route) {
            ForgotPasswordScreen(navController)
        }

        composable(Routes.MainRoute.OtpVerfitly.route) {
            OtpVerificationScreen(navController)
        }

    }

}