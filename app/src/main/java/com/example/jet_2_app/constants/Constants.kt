package com.example.jet_2_app.constants

import com.example.jet_2_app.R
import com.example.jet_2_app.model.BottomNavItem
import com.example.jet_2_app.routes.Routes

object Constants{
    val BottomNavItems = listOf<BottomNavItem>(
        BottomNavItem(labal = "Home", icon = R.drawable.ic_home, route = Routes.MainRoute.Home.route),
        BottomNavItem(labal = "Explose", icon = R.drawable.ic_explore, route =  Routes.MainRoute.Explose.route),
        BottomNavItem(labal = "Bookmark", icon = R.drawable.ic_bookmark , route = Routes.MainRoute.Bookmark.route),
        BottomNavItem(labal = "Profile", icon = R.drawable.ic_profile, route = Routes.MainRoute.Profile.route)
    )
}