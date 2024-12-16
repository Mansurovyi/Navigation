package com.example.navigation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen(navigateToSecondScreen: (String) -> Unit) {
    val name = remember { mutableStateOf("") }
    val age = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is the First Screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        // Ввод имени
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Enter your name") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Ввод возраста
        OutlinedTextField(
            value = age.value,
            onValueChange = { age.value = it },
            label = { Text("Enter your age") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Кнопка для перехода на второй экран
        Button(onClick = {
            navigateToSecondScreen("${name.value}/${age.value}")
        }) {
            Text("Go to Second Screen")
        }
    }
}
