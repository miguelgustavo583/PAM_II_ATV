package com.example.textfield.componentes

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable

fun SimpleTextField() {
    var text by remember { mutableStateOf("") }
    var isError by remember {mutableStateOf("0") }
        TextField(value = text, onValueChange = {novoValor -> text = novoValor},
    label = { Text(text = "Nome")})

    }



