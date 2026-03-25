# Calculadora Kotlin 🧮

Este é um projeto de calculadora simples utilizando Kotlin e Jetpack Compose. O foco principal é a demonstração de gerenciamento de estado e a implementação de uma classe baseada em um diagrama UML específico.

## Funcionalidades

- Interface com Jetpack Compose.
- Gerenciamento de estado reativo com `rememberSaveable` e `mutableStateOf`.
- Operações matemáticas básicas: Soma, Subtração, Multiplicação e Divisão.
- Botões estilizados com as cores do Material Design 3 (Verde - Palmeiras).
- Tratamento básico para divisão por zero.


## Como Rodar o Projeto

1. Clone este repositório ou copie o código do arquivo `MainActivity.kt`.
2. No Android Studio, vá em `File > New > New Project`.
3. Escolha **Empty Compose Activity**.
4. Certifique-se de que o Package Name seja `com.example.att_calculadora_kotlin`.
5. Cole o código no arquivo `MainActivity.kt`.
6. Clique no ícone de **Play** para rodar.

## Criando um Emulador Pixel 6

Caso não tenha um dispositivo físico ou emulador pronto, siga estes passos no Android Studio:

- Abrir o Gerenciador: No canto superior direito, clique no ícone de celular com um símbolo do Android (Device Manager) ou vá em `Tools > Device Manager`.
- Criar Dispositivo: Clique no botão + (Create Device).
- Selecionar Hardware: Na categoria Phone, procure por Pixel 6. Clique em Next.
- Configuração Final: De um nome ao emulador ou deixe o padrão. Clique em Finish.
- Iniciar: Agora, o Pixel 6 aparecerá na sua lista. Clique no ícone de "Play" ao lado dele para dar boot no Android virtual e depois rode o projeto.
