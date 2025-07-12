package com.example.jet_2_app.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.jet_2_app.navigation.MainNavigation
import com.example.jet_2_app.ui.theme.Jet_2_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jet_2_appTheme {
                MainNavigation()
            }
        }
    }
}