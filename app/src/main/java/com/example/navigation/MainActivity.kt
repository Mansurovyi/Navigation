package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation.ui.FirstScreen
import com.example.navigation.ui.SecondScreen
import com.example.navigation.ui.ThirdScreen
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "firstscreen",
        modifier = modifier
    ) {
        // Экран для ввода данных (имя и возраст)
        composable(route = "firstscreen") {
            FirstScreen { nameAndAge ->
                val (name, age) = nameAndAge.split("/")
                navController.navigate("secondscreen/$name/$age")
            }
        }

        // Экран для отображения имени и возраста
        composable(route = "secondscreen/{name}/{age}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: "No Name"
            val age = backStackEntry.arguments?.getString("age") ?: "No Age"
            SecondScreen(name = name, age = age) {
                navController.navigate("thirdscreen/$name/$age") // Переход на третий экран
            }
        }

        // Экран с дополнительной информацией (Третий экран)
        composable(route = "thirdscreen/{name}/{age}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: "No Name"
            val age = backStackEntry.arguments?.getString("age") ?: "No Age"
            ThirdScreen(name = name) {
                navController.navigateUp() // Возврат на предыдущий экран
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationTheme {
        MyApp()
    }
}
