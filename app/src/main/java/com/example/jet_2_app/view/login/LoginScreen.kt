package com.example.jet_2_app.view.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jet_2_app.R
import com.example.jet_2_app.routes.Routes.MainRoute.ForgotPassword.toForgotPassword
import com.example.jet_2_app.routes.Routes.MainRoute.Landing.toLanding
import com.example.jet_2_app.routes.Routes.MainRoute.SignUP.toSignUP

@Composable
fun LoginScreen(navController: NavController){

    val scrollState = rememberScrollState()


    Column(
        modifier = Modifier.fillMaxSize().background(color = Color(0xFF1C1E21)).verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        val email = remember { mutableStateOf("")}
        val password = remember { mutableStateOf("")}

        LoginHeader()

        Spacer(modifier = Modifier.height(20.dp))

        LoginFields(
            email.value,
            password.value,
            onEmailChange = {email.value = it},
            onPasswordChange={password.value = it},
            )

        Spacer(modifier = Modifier.height(20.dp))

        CheckboxFiled(navController)

        LoginButton(
            onLoginButtonClicked = {
               navController.toLanding()
            }
        )

        GoogleLoginButton(navController)

    }



}

@Composable
fun GoogleLoginButton(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(contentColor = Color(0xFF191584)), shape = RectangleShape){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(painter = painterResource(R.drawable.ic_profile), contentDescription = "")
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Google", color = Color.White, style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
            }

        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(contentColor = Color(0xFF191584)), shape = RectangleShape){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(painter = painterResource(R.drawable.ic_profile), contentDescription = "")
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "FaceBook", color = Color.White, style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
            }

        }
    }

    Spacer(modifier = Modifier.height(20.dp))

    Row() {
        Text(text = "don’t have an account ?", color = Color.White, style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal))
        ClickableText(text = AnnotatedString("Sign Up"), onClick = { navController.toSignUP() },  style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold,
            color = Color.Cyan // Or any color you want
        ))

    }
}

@Composable
fun CheckboxFiled(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.width(250.dp),
    ) {
        Checkbox(
            checked = false,
            onCheckedChange = {  },
            modifier = Modifier.width(20.dp).height(20.dp)
        )


        Spacer(modifier = Modifier.width(10.dp))

//        Text(text = "Remember me " , color = Color.Cyan, style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal))

        ClickableText(text = AnnotatedString("Forgot the password ?"), onClick = { navController.toForgotPassword() },  style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold,
            color = Color.Cyan
        ))

    }
}

@Composable
fun LoginButton(onLoginButtonClicked: ()-> Unit) {

    Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(20.dp)) {
        Button(onClick = onLoginButtonClicked, colors = ButtonDefaults.buttonColors(contentColor = Color(0xFF191584)),modifier = Modifier.width(250.dp), shape = RectangleShape) {
            Text(text = "Login", color = Color.White, style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
        }

        Text(
            text = "or continue with",
            color = Color.White,
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal),
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun LoginHeader() {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Welcome News App " , color = Color.White, style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.ExtraBold))
        Text(text = "Sign in to continue" ,color = Color.White, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold))
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.world_news),
            contentDescription = "Login Image",
            modifier = Modifier.height(100.dp),
        )
    }
}

@Composable
fun LoginFields(email: String, passWord: String,onEmailChange: (String) -> Unit,onPasswordChange: (String) -> Unit,) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        TextFields(
            value = email,
            label = "Email",
            placeholder = "Enter your email address",
            onValueChange = onEmailChange,
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email Icon", tint = Color.White)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next)
        )

        TextFields(
            value = passWord,
            label = "Password",
            placeholder = "Enter your password",
            onValueChange = onPasswordChange,
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Password Icon", tint = Color.White)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next)
        )
    }


}

@Composable
fun TextFields(
    value: String,
    label: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions
) {
    OutlinedTextField(
        value=value,
        onValueChange = onValueChange,
        label = { Text(text = label, color = Color.White)},
        placeholder = { Text(text = placeholder, color = Color.White)},
        leadingIcon = leadingIcon,
        keyboardOptions = keyboardOptions,

    )
}