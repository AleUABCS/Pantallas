package com.example.pantallas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pantallas.screens.showSignup
import com.example.pantallas.ui.theme.PantallasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var screen by remember { mutableStateOf("main") }
            PantallasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (screen == "main") {
                        showMain(
                            modifier = Modifier.padding(innerPadding),
                            onLoginScreen = {screen = "login"},
                            onSignupScreen = {screen = "signup"}
                        )
                    } else if (screen == "signup") {
                        showSignup(
                            Modifier.padding(innerPadding)
                        )
                    } else {
                        showLogin(
                            modifier = Modifier.padding(innerPadding),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun showMain (modifier:Modifier, onLoginScreen: () -> Unit, onSignupScreen: () -> Unit ) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(buttonColor)
            .padding(16.dp)
    ) {

        Column(
            modifier = modifier
                .background(Color.White, shape = RoundedCornerShape(24.dp))
                .align(Alignment.Center)
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 20.dp)
                ,horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                Modifier.size(mainImgSize)
            )

            Text(
                text = "Hello",
                fontSize = mainTextSize,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp)
            )

            Text(
                text = "Welcome to little drop, where you manage your daily tasks",
                Modifier
                    .width(240.dp)
                    .padding(top = 10.dp),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = Color.Gray
            )

            Button(
                onClick = onLoginScreen,
                modifier = Modifier
                    .width(buttonWidth)
                    .padding(top = 30.dp)
                    .height(buttonHeight)
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor
                )

            ) {
                Text("Login")
            }

            OutlinedButton(
                onClick = onSignupScreen,
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.dp, buttonColor),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = buttonColor
                ),
                modifier = Modifier
                    .padding(top = 12.dp)
                    .width(buttonWidth)
                    .height(buttonHeight - 2.dp)
            ) {
                Text("Sign Up")
            }

            Text(
                modifier = Modifier.padding(top = 30.dp),
                text = "Sign up using",
                fontSize = 12.sp
            )

            Row (
                Modifier
                    .padding(top = 5.dp)
                    .width(130.dp)
                ,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "logo",
                    Modifier.size(25.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.google_plus),
                    contentDescription = "logo",
                    Modifier.size(25.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.linkedin),
                    contentDescription = "logo",
                    Modifier.size(25.dp)
                )
            }
        }
    }
}

@Composable
fun showLogin (modifier: Modifier) {
    var name by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(buttonColor)
            .padding(16.dp)
    ) {
        Column(
            modifier = modifier
                .background(Color.White, shape = RoundedCornerShape(24.dp))
                .align(Alignment.Center)
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 20.dp)
            ,horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_main_img),
                contentDescription = "logo",
                Modifier.size(mainImgSize)
            )

            Text (
                text = "Login",
                fontSize = mainTextSize,
                fontWeight = FontWeight.Bold
            )

            Text (
                text = "Name",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 40.dp)
            )
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFFFFFF),
                    unfocusedContainerColor = Color(0xFFFFFFFF),
                    focusedBorderColor = Color.LightGray,
                    unfocusedTextColor = Color.LightGray
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(50.dp)
            )

            Text (
                text = "Email",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 40.dp)
                    .padding(top = 20.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFFFFFF),
                    unfocusedContainerColor = Color(0xFFFFFFFF),
                    focusedBorderColor = Color.LightGray,
                    unfocusedTextColor = Color.LightGray
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(50.dp)
            )

            Text (
                text = "Password",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 40.dp)
                    .padding(top = 20.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFFFFFF),
                    unfocusedContainerColor = Color(0xFFFFFFFF),
                    focusedBorderColor = Color.LightGray,
                    unfocusedTextColor = Color.LightGray
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(50.dp)
            )

            Text (
                text = "Forgot password?",
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 10.dp)
                    .padding(start = 50.dp)
            )

            Button(
                onClick = {},
                modifier = Modifier
                    .width(135.dp)
                    .height(buttonHeight)
                    .align(Alignment.End)
                    .padding(end = 35.dp)
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor
                )

            ) {
                Text("Sign Up")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PantallasTheme {
        Greeting("Android")
    }
}