package com.example.pantallas.screens

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pantallas.R

@Composable
fun showContact (name: String, phone: String) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.donpollo),
            contentDescription = "Contacto"
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text (
                text = name,
                fontSize = 32.sp,
            )
            Text(
                text = phone,
                fontSize = 28.sp,
            )
        }
    }
}

@Composable
fun newContact () {
    Column {
        Text (
            text = "Nombre"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun preview () {
    showContact("Don Pollo", "6131177777")
}
