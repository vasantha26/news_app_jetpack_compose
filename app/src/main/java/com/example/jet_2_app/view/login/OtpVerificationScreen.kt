package com.example.jet_2_app.view.login

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun OtpVerificationScreen(navController: NavController) {
    var otp by remember { mutableStateOf(List(4) { "" }) }
    var errorMessage by remember { mutableStateOf("Invalid OTP") }
    var showError by remember { mutableStateOf(true) }

    val focusRequesters = List(4) { FocusRequester() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F0F2C))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "OTP Verification",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "Enter the OTP sent to +67-1234-5678-9",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                otp.forEachIndexed { index, value ->
                    OutlinedTextField(
                        value = value,
                        onValueChange = {
                            if (it.length <= 1) {
                                otp = otp.toMutableList().apply { set(index, it) }
                                if (it.isNotEmpty() && index < 3) {
                                    focusRequesters[index + 1].requestFocus()
                                }
                            }
                        },
                        singleLine = true,
                        modifier = Modifier
                            .size(60.dp)
                            .focusRequester(focusRequesters[index])
                            .background(Color(0xFFF3EAFD), RoundedCornerShape(8.dp)),
                        textStyle = TextStyle(
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            color = Color.Black
                        )
                    )
                }
            }

            if (showError) {
                Text(
                    text = "ⓘ $errorMessage",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 8.dp).align(Alignment.CenterHorizontally)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Resend code in 56s",
                color = Color(0xFFFF4081),
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        Button(
            onClick = {  },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Verify", color = Color.White)
        }
    }
}
