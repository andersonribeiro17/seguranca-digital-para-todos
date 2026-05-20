package com.example.segurancadigital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay
import androidx.compose.runtime.LaunchedEffect

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                NavegacaoApp()
            }
        }
    }
}

@Composable
fun NavegacaoApp() {

    val navController = rememberNavController()

    var mostrarSplash by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(Unit) {

        delay(2500)

        mostrarSplash = false
    }

    if (mostrarSplash) {

        SplashScreen()

    } else {

        NavHost(
            navController = navController,
            startDestination = "inicio"
        ) {

            composable("inicio") {
                TelaInicial(navController)
            }

            composable("golpes") {
                TelaGolpes(navController)
            }

            composable("dicas") {
                TelaDicas(navController)
            }

            composable("faq") {
                TelaFAQ(navController)
            }

            composable("quiz") {
                TelaQuiz(navController)
            }
        }
    }
}

@Composable
fun TelaInicial(navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF4F7FB)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",

                modifier = Modifier.size(180.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Segurança Digital",
                fontSize = 34.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF0D47A1)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Aprenda a se proteger de golpes virtuais.",
                fontSize = 18.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(40.dp))

            BotaoMenu(
                texto = "Golpes Mais Comuns",
                icone = Icons.Default.Warning
            ) {
                navController.navigate("golpes")
            }

            Spacer(modifier = Modifier.height(16.dp))

            BotaoMenu(
                texto = "Dicas de Segurança",
                icone = Icons.Default.Lock
            ) {
                navController.navigate("dicas")
            }

            Spacer(modifier = Modifier.height(16.dp))

            BotaoMenu(
                texto = "Perguntas Frequentes",
                icone = Icons.Default.Info
            ) {
                navController.navigate("faq")
            }

            Spacer(modifier = Modifier.height(16.dp))

            BotaoMenu(
                texto = "Quiz Educativo",
                icone = Icons.Default.School
            ) {
                navController.navigate("quiz")
            }
        }
    }
}

@Composable
fun BotaoMenu(
    texto: String,
    icone: ImageVector,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,

        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),

        shape = RoundedCornerShape(18.dp),

        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1565C0)
        ),

        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp
        )
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = icone,
                contentDescription = null,
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = texto,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

@Composable
fun TelaGolpes(navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF2F5F9)
    ) {

        Column {

            BarraSuperior(
                titulo = "Golpes Mais Comuns"
            ) {
                navController.popBackStack()
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {

                Spacer(modifier = Modifier.height(16.dp))

                CardGolpe(
                    titulo = "Golpe do WhatsApp",
                    descricao = "Criminosos tentam clonar contas para pedir dinheiro aos contatos."
                )

                Spacer(modifier = Modifier.height(16.dp))

                CardGolpe(
                    titulo = "PIX Falso",
                    descricao = "Mensagens falsas simulando comprovantes de pagamento."
                )

                Spacer(modifier = Modifier.height(16.dp))

                CardGolpe(
                    titulo = "Links Suspeitos",
                    descricao = "Links enviados por SMS ou redes sociais para roubar dados."
                )

                Spacer(modifier = Modifier.height(16.dp))

                CardGolpe(
                    titulo = "Falso Suporte Técnico",
                    descricao = "Golpistas fingem ser empresas para obter acesso ao celular."
                )
            }
        }
    }
}

@Composable
fun TelaDicas(navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF2F5F9)
    ) {

        Column {

            BarraSuperior(
                titulo = "Dicas de Segurança"
            ) {
                navController.popBackStack()
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {

                Spacer(modifier = Modifier.height(16.dp))

                CardDica(
                    titulo = "Use senhas fortes",
                    descricao = "Crie senhas com letras, números e caracteres especiais."
                )

                Spacer(modifier = Modifier.height(12.dp))

                CardDica(
                    titulo = "Ative autenticação em dois fatores",
                    descricao = "Isso aumenta a proteção das suas contas."
                )

                Spacer(modifier = Modifier.height(12.dp))

                CardDica(
                    titulo = "Evite Wi-Fi público",
                    descricao = "Redes abertas podem facilitar roubo de dados."
                )

                Spacer(modifier = Modifier.height(12.dp))

                CardDica(
                    titulo = "Desconfie de links",
                    descricao = "Nunca clique em links suspeitos recebidos por SMS ou WhatsApp."
                )

                Spacer(modifier = Modifier.height(12.dp))

                CardDica(
                    titulo = "Mantenha o celular atualizado",
                    descricao = "Atualizações corrigem falhas de segurança."
                )
            }
        }
    }
}

@Composable
fun TelaFAQ(navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF2F5F9)
    ) {

        Column {

            BarraSuperior(
                titulo = "Perguntas Frequentes"
            ) {
                navController.popBackStack()
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {

                Spacer(modifier = Modifier.height(16.dp))

                CardDica(
                    titulo = "O banco pede senha por telefone?",
                    descricao = "Não. Bancos nunca pedem senha completa por ligação ou WhatsApp."
                )

                Spacer(modifier = Modifier.height(12.dp))

                CardDica(
                    titulo = "Posso confiar em links enviados por SMS?",
                    descricao = "Sempre confirme a origem antes de clicar."
                )

                Spacer(modifier = Modifier.height(12.dp))

                CardDica(
                    titulo = "Como saber se um site é seguro?",
                    descricao = "Verifique se possui HTTPS e cadeado ao lado do endereço."
                )

                Spacer(modifier = Modifier.height(12.dp))

                CardDica(
                    titulo = "Wi-Fi público é perigoso?",
                    descricao = "Pode expor seus dados pessoais e senhas."
                )
            }
        }
    }
}

@Composable
fun TelaQuiz(navController: NavController) {

    val perguntas = listOf(
        Pair("É seguro clicar em links desconhecidos enviados por SMS?", "Não"),
        Pair("Golpistas podem clonar contas do WhatsApp?", "Sim"),
        Pair("Usar senha fraca aumenta o risco de invasão?", "Sim"),
        Pair("Wi-Fi público é totalmente seguro para acessar banco?", "Não"),
        Pair("Atualizar o celular ajuda na segurança?", "Sim")
    )

    var perguntaAtual by remember { mutableStateOf(0) }
    var pontuacao by remember { mutableStateOf(0) }
    var respostaMensagem by remember { mutableStateOf("") }
    var quizFinalizado by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF2F5F9)
    ) {

        Column {

            BarraSuperior(
                titulo = "Quiz Educativo"
            ) {
                navController.popBackStack()
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(16.dp))

                if (!quizFinalizado) {

                    Text(
                        text = "Pergunta ${perguntaAtual + 1} de ${perguntas.size}",
                        fontSize = 18.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {

                            Text(
                                text = perguntas[perguntaAtual].first,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Button(
                        onClick = {

                            if (perguntas[perguntaAtual].second == "Sim") {
                                pontuacao++
                                respostaMensagem = "✅ Resposta correta!"
                            } else {
                                respostaMensagem = "❌ Resposta incorreta!"
                            }

                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),

                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("Sim")
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {

                            if (perguntas[perguntaAtual].second == "Não") {
                                pontuacao++
                                respostaMensagem = "✅ Resposta correta!"
                            } else {
                                respostaMensagem = "❌ Resposta incorreta!"
                            }

                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),

                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("Não")
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = respostaMensagem,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {

                            respostaMensagem = ""

                            if (perguntaAtual < perguntas.size - 1) {
                                perguntaAtual++
                            } else {
                                quizFinalizado = true
                            }

                        },

                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("Próxima Pergunta")
                    }

                } else {

                    Text(
                        text = "Quiz Finalizado!",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1565C0)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Sua pontuação foi:",
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "$pontuacao / ${perguntas.size}",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0D47A1)
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Button(
                        onClick = {

                            perguntaAtual = 0
                            pontuacao = 0
                            respostaMensagem = ""
                            quizFinalizado = false

                        },

                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("Reiniciar Quiz")
                    }
                }
            }
        }
    }
}

@Composable
fun CardGolpe(
    titulo: String,
    descricao: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = titulo,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = descricao,
                fontSize = 16.sp,
                color = Color.DarkGray
            )
        }
    }
}

@Composable
fun CardDica(
    titulo: String,
    descricao: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = titulo,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = descricao,
                fontSize = 16.sp,
                color = Color.DarkGray
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior(
    titulo: String,
    aoVoltar: (() -> Unit)? = null
) {

    TopAppBar(

        title = {
            Text(
                text = titulo,
                fontWeight = FontWeight.Bold
            )
        },

        navigationIcon = {

            if (aoVoltar != null) {

                IconButton(
                    onClick = aoVoltar
                ) {

                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Voltar"
                    )
                }
            }
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF1565C0),
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        )
    )
}
@Composable
fun SplashScreen() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF1565C0)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",

                modifier = Modifier.size(220.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Segurança Digital",
                fontSize = 34.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            Text(
                text = "Para Todos",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFB3E5FC)
            )

            Spacer(modifier = Modifier.height(20.dp))

            CircularProgressIndicator(
                color = Color.White
            )
        }
    }
}