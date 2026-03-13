package com.example.pantallas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pantallas.screens.*
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