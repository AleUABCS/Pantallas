package com.example.pantallas.screens

import android.graphics.Paint
import android.icu.text.ListFormatter
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pantallas.R

@Composable
fun showContact (name: String, phone: String) {
    Row (
        modifier = Modifier
            .padding(
                start = 50.dp,
                end = 60.dp,
                top = 20.dp
            )
        ,

    )
    {
        Image(
            painter = painterResource(id = R.drawable.donpollo),
            contentDescription = "Contacto",
            Modifier
                .size(75.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(30.dp))

        Column {
            Text (
                text = name,
                fontSize = 22.sp,
            )

            Text(
                text = phone,
                fontSize = 20.sp,
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.contact_icon),
            contentDescription = "Flecha",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(20.dp)

            ,
        )
    }
}

@Composable
fun newContact () {
    // Textfields y labels
    Column (
        modifier = Modifier
            .padding(start = 40.dp, end = 40.dp)
    )

    {
        Text (
            text = "Nombre",
            fontSize = 18.sp,
            color = Color.Gray

        )

        Spacer(Modifier.height(3.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFFFFFFF),
                unfocusedContainerColor = Color(0xFFFFFFFF),
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.LightGray
            ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        Text (
            text = "Número de teléfono",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Spacer(Modifier.height(3.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFFFFFFF),
                unfocusedContainerColor = Color(0xFFFFFFFF),
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.LightGray
            ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        )
        // Botones "Agregar" y "Eliminar"
        Row(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = {},
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.dp, Color(0xFF83B484)),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFF83B484)
                ),
                modifier = Modifier
                    .width(135.dp)
                    .height(buttonHeight - 2.dp)
            ) {
                Text("Limpiar")
            }

            Spacer(Modifier.width(20.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .width(135.dp)
                    .height(buttonHeight)
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF83B484)
                )

            ) {
                Text("Agregar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun preview () {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {
        newContact()
        showContact("Don Pollo", "6131177777")
    }
}
