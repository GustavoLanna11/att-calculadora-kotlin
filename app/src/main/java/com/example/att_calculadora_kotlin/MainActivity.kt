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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.att_calculadora_kotlin.ui.theme.AttcalculadorakotlinTheme

// Classe conforme o UML: Atributos num01 e num02 e métodos sem parâmetros
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

    // Configuração de cor verde para os botões
    val configCoresVerde = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF2E7D32),
        contentColor = Color.White
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Calculadora Estática", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(10.dp))

        // Exibindo os números definidos na classe
        Text(text = "Número 1: ${calc.num01}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Número 2: ${calc.num02}", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { resultado = "Resultado: ${calc.somar()}" }, colors = configCoresVerde) { Text("+") }
            Button(onClick = { resultado = "Resultado: ${calc.subtrair()}" }, colors = configCoresVerde) { Text("-") }
            Button(onClick = { resultado = "Resultado: ${calc.multiplicar()}" }, colors = configCoresVerde) { Text("*") }
            Button(onClick = { resultado = "Resultado: ${calc.dividir()}" }, colors = configCoresVerde) { Text("/") }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Visor que atualiza em tempo real
        Text(
            text = resultado,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}