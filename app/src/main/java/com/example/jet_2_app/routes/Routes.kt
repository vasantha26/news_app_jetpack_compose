package com.example.jet_2_app.routes

import androidx.navigation.NavController

sealed class Routes(val route : String) {

    data object MainRoute : Routes("mainRoutes"){

        data object Splash: Routes("${Routes.MainRoute.route}/splash"){
            fun NavController.toSplash() = navigate("${Routes.MainRoute.route}/splash")
        }

        data object OnboardingPager: Routes("${Routes.MainRoute.route}/onboardingPager"){
            fun NavController.toOnboardingPager() = navigate("${Routes.MainRoute.route}/onboardingPager")
        }
        data object Onboarding: Routes("${Routes.MainRoute.route}/onboarding"){
            fun NavController.toOnboarding() = navigate("${Routes.MainRoute.route}/onboarding")
        }

        data object Login: Routes("${Routes.MainRoute.route}/login"){
            fun NavController.toLogin() = navigate("${Routes.MainRoute.route}/login")
        }

        data object SignUP : Routes("${MainRoute.route}/signup") {
            fun NavController.toSignUP() = navigate(route)
        }

        data object ForgotPassword : Routes("${MainRoute.route}/forgotPassword") {
            fun NavController.toForgotPassword() = navigate(route)
        }

        data object OtpVerfitly : Routes("${MainRoute.route}/otpVerfitly") {
            fun NavController.toOtpVerfitly() = navigate(route)
        }


        data object Profile : Routes("${MainRoute.route}/profile"){
            fun NavController.toProfile() = navigate("${route}/profile")
        }

        data object Home : Routes("${Routes.MainRoute.route}/home") {
            fun NavController.toHome() = navigate("${Routes.MainRoute.route}/home")

        }

        data object Landing : Routes("${Routes.MainRoute.route}/landing") {
            fun NavController.toLanding() = navigate("${Routes.MainRoute.route}/landing")

        }

        data object Explose : Routes("${Routes.MainRoute.route}/explose") {
            fun NavController.toExplose() = navigate("${Routes.MainRoute.route}/explose")
        }

        data object Bookmark : Routes("${Routes.MainRoute.route}/bookmark") {
            fun NavController.toBookmark() = navigate("${Routes.MainRoute.route}/bookmark")
        }


    }
}