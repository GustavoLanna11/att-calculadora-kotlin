package com.example.att_calculadora_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

// Imports do Compose para Layout
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

// Import do tema
import com.example.att_calculadora_kotlin.ui.theme.AttcalculadorakotlinTheme

// Criação das classes
class Calculadora {
    fun somar(n1: Double, n2: Double) = n1 + n2
    fun subtrair(n1: Double, n2: Double) = n1 - n2
    fun multiplicar(n1: Double, n2: Double) = n1 * n2
    fun dividir(n1: Double, n2: Double) = if (n2 != 0.0) n1 / n2 else 0.0
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AttcalculadorakotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
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
    AttcalculadorakotlinTheme {
        Greeting("Android")
    }
}