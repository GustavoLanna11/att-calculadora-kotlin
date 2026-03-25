package com.example.att_calculadora_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.att_calculadora_kotlin.ui.theme.AttcalculadorakotlinTheme

// Classe conforme o UML
class Calculadora {
    var num01: Double = 5.0
    var num02: Double = 5.0

    fun somar(): Double = num01 + num02
    fun subtrair(): Double = num01 - num02
    fun multiplicar(): Double = num01 * num02
    fun dividir(): Double = if (num02 != 0.0) num01 / num02 else 0.0
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AttcalculadorakotlinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculadoraScreen()
                }
            }
        }
    }
}

@Composable
fun CalculadoraScreen() {
    var resultado by rememberSaveable { mutableStateOf("Resultado: ") }
    val calc = remember { Calculadora() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Calculadora Estática", style = MaterialTheme.typography.headlineMedium)

        // Exibindo os números que já estão definidos na classe
        Text(text = "Número 01: ${calc.num01}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Número 02: ${calc.num02}", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(20.dp))

        // Row com os botões de operação
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { resultado = "Resultado: ${calc.somar()}" }) { Text("+") }
            Button(onClick = { resultado = "Resultado: ${calc.subtrair()}" }) { Text("-") }
            Button(onClick = { resultado = "Resultado: ${calc.multiplicar()}" }) { Text("*") }
            Button(onClick = { resultado = "Resultado: ${calc.dividir()}" }) { Text("/") }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Visor reativo
        Text(
            text = resultado,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}