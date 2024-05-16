package com.example.aulapam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.benchmark.perfetto.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aulapam.ui.theme.AulaPAMTheme
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AulaPAMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    register()
                }
            }
        }
    }
}

@Composable
fun register() {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxWidth(),
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Text(
                text = "Formulário",
                fontSize = 30.sp
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 50.dp),
        )

        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center

        ) {
            TextField(
                value = email, onValueChange = { novoValor -> email = novoValor },
                label = { Text("Email:") },
            )
        }

        Spacer(modifier = Modifier.height(26.dp))

        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center

        ) {
            TextField(
                value = senha, onValueChange = { novoValor -> senha = novoValor },
                label = { Text("Senha: ") },
            )
        }

        Spacer(modifier = Modifier.height(26.dp))

        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center

        ) {
            Button(onClick = {
                if (email.isEmpty() || senha.isEmpty()) {
                    errorMessage = "Por favor, preencha todos os campos."
                } else {

                    errorMessage = ""

                }
            }) {
                Text(text = "Entrar")

            }
        }

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp),
            )
        }
    }
}

@Composable
@Preview
fun registerPreview() {
    Surface (
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background
    ) {
        register()
    }
}