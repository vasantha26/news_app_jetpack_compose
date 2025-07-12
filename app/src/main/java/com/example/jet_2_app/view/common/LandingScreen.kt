package com.example.jet_2_app.view.common

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jet_2_app.constants.Constants
import com.example.jet_2_app.routes.Routes
import com.example.jet_2_app.routes.Routes.MainRoute.Login.toLogin
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LandingScreen(navController: NavHostController) {

    val navController = rememberAnimatedNavController()

    Scaffold(
        containerColor = Color.White, // 👈 Set background color here
        topBar = { /* AppBarHomeScreen(navController) */ },
        bottomBar = { BottomNavigationBar(navController = navController) },
        content = { padding ->
            NavHostContainer(navController = navController, padding = padding)
        }
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavHostContainer(navController: NavHostController, padding: PaddingValues) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Routes.MainRoute.Home.route,
        modifier = Modifier.padding(padding)
    ) {
        composable(Routes.MainRoute.Home.route) {
            HomeScreen(navController)
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
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    NavigationBar(

        // set background color
        containerColor = Color(0xFF1E1E1F)
    ) {

        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // observe current route to change the icon
        // color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        // Bottom nav items we declared
        Constants.BottomNavItems.forEach { navItem ->

            // Place the bottom nav items
            NavigationBarItem(

                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    navController.navigate(navItem.route)
                },

                // Icon of navItem
                icon = {
                    Icon(
                        painter = painterResource(id = navItem.icon),
                        contentDescription = navItem.labal
                    )
                },

                // label
                label = {
                    Text(text = navItem.labal)
                },

                alwaysShowLabel = true,

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White, // Icon color when selected
                    unselectedIconColor = Color.White, // Icon color when not selected
                    selectedTextColor = Color.White, // Label color when selected
                    indicatorColor = Color(0xFF191A53) // Highlight color for selected item
                )
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarHomeScreen(navController: NavHostController) {

    TopAppBar(
        title = { Text(text = "Home") },
        navigationIcon = {
            IconButton(onClick = {navController.toLogin()},) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        },
     )
}
