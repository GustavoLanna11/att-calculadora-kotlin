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

// Classe conforme o UML
class Calculadora {

    // Declaração das variáveis
    var num01: Double = 5.0
    var num02: Double = 5.0

    // Criação das funções para realizar as operações básicas
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
    // Responsável pelo Estado Reativo - Ao girar a tela o valor é mantido
    var resultado by rememberSaveable { mutableStateOf("Resultado: ") }
    val calc = remember { Calculadora() }

    // Configuração de cor verde para os botões
    val configCoresVerde = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF2E7D32),
        contentColor = Color.White
    )

    // Responsável por "empilhar" os elementos
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Título do Projeto
        Text(text = "Calculadora - Kotlin", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(10.dp))

        // Exibindo os números definidos na classe
        Text(text = "Número 1: ${calc.num01}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Número 2: ${calc.num02}", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(20.dp))

        // Configuração da "Linha" para exibir as operações básicas
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Lista de botões para efetuar as operações básicas
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