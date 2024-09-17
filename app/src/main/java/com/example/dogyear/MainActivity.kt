package com.example.aosperro

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dogyear.R
import com.example.dogyear.ui.theme.DogYearTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DogYearTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    DogApp()
                }
            }
        }
    }
}
@Composable
fun DogApp() {
    var age by remember { mutableStateOf("") }
    var dogAge by remember { mutableStateOf("") }

    val dogImage: Painter = painterResource(id = R.drawable.fb_img_1714510715793)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen del perro
        Image(
            painter = dogImage,
            contentDescription = "Dog Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para ingresar la edad
        TextField(
            value = age,
            onValueChange = { newAge -> age = newAge },
            label = { Text("Ingresa tú edad en años humanos") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para calcular la edad del perro
        Button(onClick = {
            val humanAge = age.toIntOrNull()
            dogAge = if (humanAge != null) {
                val convertedAge = humanAge * 7
                "Tú edad en perro es aproximadamente $convertedAge años."
            } else {
                "Por favor, ingrese una edad válida."
            }
        }) {
            Text("Calcular edad en perro")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar el resultado
        Text(
            text = dogAge,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DogYearTheme {
        DogApp()
    }
}