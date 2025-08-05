package br.senai.sp.jandira.clientesapp.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.clientesapp.R
import br.senai.sp.jandira.clientesapp.model.Cliente
import br.senai.sp.jandira.clientesapp.ui.theme.ClientesAppTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
           BarraDeTitulo() //desenhamos abaixo
        },
        bottomBar = {
           BarraDeNavegacao() //desenhamos abaixo
        },
        floatingActionButton = {
            BotaoFlutuante()
        },
    ){ paddingValues ->
        Column (
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background) //cor do fundo
        ){
            Row( // conteudo
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Icone da Lista de Clientes",
                    tint = MaterialTheme.colorScheme.onBackground //cor do conteudo do background
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Lista de Clientes"
                )
            }
            LazyColumn { //quantas vezes aparecem os cards
                items(10) {
                    ClienteCard()
                }
            }
        }
    }
}
//-------------------------------------
@Composable
fun ClienteCard(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(
                start = 8.dp,
                end = 8.dp,
                bottom = 4.dp
            ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary) // cor do card
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "Nome do Cliente",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(text = "email@cliente",
                    fontSize = 12.sp
                )
            }
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Excluir"
            )
        }
    }
}
//-------------------------------------
@Preview
@Composable
private fun ClienteCardPreview() {
    ClientesAppTheme {
        ClienteCard()
    }
}
//-------------------------------------
@OptIn(ExperimentalMaterial3Api::class) //importa do TopAppBar
@Composable
fun BarraDeTitulo(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp),
        colors = TopAppBarDefaults
            .topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
        title = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, //espacar itens
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Rafaella Reis",
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimary //cor para o texto
                    )
                    Text(
                        text = "rafareis@email.com",
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimary //cor para o texto
                    )
                }
                Card(
                    modifier = Modifier
                        .size(60.dp)
                        .padding(4.dp),
                    shape = CircleShape
                ){
                    Image(
                        painter = painterResource(R.drawable.icon),
                        contentDescription = "Foto de Perfil"
                    )
                }
            }
        }
    )
}
//-------------------------------------
@Composable
fun BarraDeNavegacao(modifier: Modifier = Modifier) { //barra inferior
   NavigationBar(
       containerColor = MaterialTheme.colorScheme.primary, //mudar a cor
       contentColor = MaterialTheme.colorScheme.primary //mudar a cor
   ) { //composta por itens de barra de navigacao
       NavigationBarItem(
           selected = false,
           onClick = {},
           icon = {
               Icon(
                   imageVector = Icons.Default.Home,
                   contentDescription = "Home",
                   tint = MaterialTheme.colorScheme.onPrimary //mudar a cor do icon
               )
           },
           label = { //texto para o icon
                Text(text = "Home",
                    color = MaterialTheme.colorScheme.onPrimary) //mudar a cor do texto
           }
       )
       NavigationBarItem(
           selected = false,
           onClick = {},
           icon = {
               Icon(
                   imageVector = Icons.Default.Favorite,
                   contentDescription = "Favorite",
                   tint = MaterialTheme.colorScheme.onPrimary
               )
           },
           label = { //texto para o icon
               Text(text = "Favorite",
                   color = MaterialTheme.colorScheme.onPrimary)
           }
       )
       NavigationBarItem(
           selected = false,
           onClick = {},
           icon = {
               Icon(
                   imageVector = Icons.Default.Menu,
                   contentDescription = "Menu",
                   tint = MaterialTheme.colorScheme.onPrimary
               )
           },
           label = { //texto para o icon
               Text(text = "Menu",
                   color = MaterialTheme.colorScheme.onPrimary)
           }
       )
   }
}
//-------------------------------------
@Composable
fun BotaoFlutuante(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = {},
        containerColor = MaterialTheme.colorScheme.tertiary // cor do botao flutuante
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Botão Adicionar",
            tint = MaterialTheme.colorScheme.onTertiary
        )
    }
}
//-------------------------------------
@Preview
@Composable
private fun BotaoFlutuantePreview() {
    ClientesAppTheme {
        BotaoFlutuante()
    }
}
//-------------------------------------
@Preview
@Composable
private fun BarraDeNavegacaoPreview() {
    ClientesAppTheme {
        BarraDeNavegacao()
    }
}
//-------------------------------------
@Preview
@Composable
private fun BarraDeTituloPreview() {
    ClientesAppTheme {
        BarraDeTitulo()
    }
}
//-------------------------------------
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES) //configuracoes para temas
@Composable
private fun HomeScreenPreview() {
    ClientesAppTheme {
        HomeScreen()
    }
}