package com.example.navigation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(name: String, age: String, navigateBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Отображение имени и возраста
        Text("Hello, $name! You are $age years old.", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        // Кнопка для возврата на первый экран
        Button(onClick = navigateBack) {
            Text("Go Back")
        }
    }
}
