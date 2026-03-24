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
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                CalculadoraScreen()
            }
        }
    }
}

@Composable
fun CalculadoraScreen() {
    // Inicializando as variáveis com valor definido
    var num1 by rememberSaveable { mutableStateOf("5") }
    var num2 by rememberSaveable { mutableStateOf("5") }
    var resultado by rememberSaveable { mutableStateOf("Resultado: ") }

    val calc = Calculadora()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Minha Calculadora", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        // Input 1
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Input 2
        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 3. Row com os 4 botões
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val n1 = num1.toDoubleOrNull() ?: 0.0
            val n2 = num2.toDoubleOrNull() ?: 0.0

            Button(onClick = { resultado = "Resultado: ${calc.somar(n1, n2)}" }) { Text("+") }
            Button(onClick = { resultado = "Resultado: ${calc.subtrair(n1, n2)}" }) { Text("-") }
            Button(onClick = { resultado = "Resultado: ${calc.multiplicar(n1, n2)}" }) { Text("*") }
            Button(onClick = { resultado = "Resultado: ${calc.dividir(n1, n2)}" }) { Text("/") }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // 4. Texto de resultado
        Text(
            text = resultado,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}