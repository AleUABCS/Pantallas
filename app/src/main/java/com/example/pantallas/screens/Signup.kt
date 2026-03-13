package com.example.pantallas.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.pantallas.R

@Composable
fun showSignup (modifier: Modifier) {

    // State variables
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("")}

    // Email field validation
    val emailHasErrors by remember {
        derivedStateOf {
            if (email.isNotEmpty()) {
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
            } else {
                false
            }
        }
    }

    val emailStateColor by remember {
        derivedStateOf {
            if (emailHasErrors) Color.Red
            else if (email.isEmpty()) Color.Gray
            else buttonColor
        }
    }

    // Name field validation
    val nameHasErrors by remember {
        derivedStateOf {
            name.isNotEmpty() && !name.all { it.isLetter() }
        }
    }

    val nameStateColor by remember {
        derivedStateOf {
            if (name.isEmpty()) Color.Gray
            else if (nameHasErrors) Color.Red
            else buttonColor
        }
    }

    // Password validation
    val passwordIsSafe by remember {
        derivedStateOf {
            if (password.isNotEmpty()) {
                password.length > 10 &&
                password.any { it.isLetter()} &&
                password.any { it.isDigit()} &&
                password.any { it.isUpperCase()} &&
                password.any { it.isLowerCase()}
            } else
                false
        }
    }

    val passwordStateColor by remember {
        derivedStateOf {
            if (password.isNotEmpty() && !passwordIsSafe) Color.Red
            else if (password.isEmpty()) Color.Gray
            else buttonColor
        }
    }

    // Confirm password validation
    val confirmPasswordIsCorrect by remember { derivedStateOf { password == confirmPassword }}

    val confirmPasswordStateColor by remember {
        derivedStateOf {
            if (confirmPassword.isNotEmpty() && confirmPasswordIsCorrect) buttonColor
            else if (confirmPassword.isEmpty()) Color.Gray
            else Color.Red
        }
    }

    // Phone validation
    val phoneHasErrors by remember {
        derivedStateOf {
            phone.isNotEmpty() &&
            !(phone.all { it.isDigit() } && phone.length == 10)
        }
    }

    val phoneStateColor by remember {
        derivedStateOf {
            if (phoneHasErrors) Color.Red
            else if (phone.isEmpty()) Color.Gray
            else buttonColor
        }
    }

    // Continue button color validation
    val allFieldsCorrect by remember {
        derivedStateOf {
            if (
                name.isNotEmpty() && !nameHasErrors &&
                email.isNotEmpty() && !emailHasErrors &&
                password.isNotEmpty() && passwordIsSafe &&
                confirmPassword.isNotEmpty() && confirmPasswordIsCorrect &&
                phone.isNotEmpty() && !phoneHasErrors
            )
                true
            else
                false
        }
    }

    val buttonStateColor by remember {
        derivedStateOf {
            if (allFieldsCorrect) buttonColor
            else Color.LightGray
        }
    }

    // Screen
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
                .padding(top = 20.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.signup_main_img),
                contentDescription = "",
                Modifier.size(mainImgSize - 100.dp)
            )

            Text (
                text = "Sign Up",
                fontSize = mainTextSize,
                fontWeight = FontWeight.Bold
            )

            Text (
                text = "Name",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 40.dp)
                    .padding(top = 10.dp)
            )
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFFFFFF),
                    unfocusedContainerColor = Color(0xFFFFFFFF),
                    focusedBorderColor = nameStateColor,
                    unfocusedTextColor = nameStateColor
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
                    .padding(top = 10.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFFFFFF),
                    unfocusedContainerColor = Color(0xFFFFFFFF),
                    focusedBorderColor = emailStateColor,
                    unfocusedTextColor = emailStateColor
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
                    .padding(top = 10.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it},
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFFFFFF),
                    unfocusedContainerColor = Color(0xFFFFFFFF),
                    focusedBorderColor = passwordStateColor,
                    unfocusedTextColor = passwordStateColor
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(50.dp)
            )

            Text (
                text = "Confirm password",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 40.dp)
                    .padding(top = 10.dp)
            )
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFFFFFF),
                    unfocusedContainerColor = Color(0xFFFFFFFF),
                    focusedBorderColor = confirmPasswordStateColor,
                    unfocusedTextColor = confirmPasswordStateColor
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(50.dp)
            )

            Text (
                text = "Phone",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 40.dp)
                    .padding(top = 10.dp)
            )
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFFFFFF),
                    unfocusedContainerColor = Color(0xFFFFFFFF),
                    focusedBorderColor = phoneStateColor,
                    unfocusedTextColor = phoneStateColor
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(50.dp)
            )

            Button(
                onClick = {},
                enabled = allFieldsCorrect,
                modifier = Modifier
                    .width(150.dp)
                    .padding(top = 10.dp)
                    .height(buttonHeight)
                    .align(Alignment.End)
                    .padding(end = 35.dp)
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonStateColor,
                    disabledContainerColor = buttonStateColor
                )

            ) {
                Text("Continue")
            }

        }
    }
}