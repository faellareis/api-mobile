package br.senai.sp.jandira.clientesapp.screens

import android.adservices.topics.Topic
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.clientesapp.R
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
                .background(Color.Gray)
        ){
            Text(text = "Aqui fica o conteúdo")
        }
    }
}
//-------------------------------------
@OptIn(ExperimentalMaterial3Api::class) //importa do TopAppBar
@Composable
fun BarraDeTitulo(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        title = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, //espacar itens
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Rafaella Reis",
                        fontSize = 16.sp
                    )
                    Text(
                        text = "rafareis@email.com",
                        fontSize = 16.sp
                    )
                }
                Card(
                    modifier = Modifier
                        .size(60.dp),
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
   NavigationBar { //composta por itens de barra de navigacao
       NavigationBarItem(
           selected = false,
           onClick = {},
           icon = {
               Icon(
                   imageVector = Icons.Default.Home,
                   contentDescription = "Home"
               )
           },
           label = { //texto para o icon
                Text(text = "Home")
           }
       )
       NavigationBarItem(
           selected = false,
           onClick = {},
           icon = {
               Icon(
                   imageVector = Icons.Default.Favorite,
                   contentDescription = "Favorite"
               )
           },
           label = { //texto para o icon
               Text(text = "Favorite")
           }
       )
       NavigationBarItem(
           selected = false,
           onClick = {},
           icon = {
               Icon(
                   imageVector = Icons.Default.Menu,
                   contentDescription = "Menu"
               )
           },
           label = { //texto para o icon
               Text(text = "Menu")
           }
       )
   }
}
//-------------------------------------
@Composable
fun BotaoFlutuante(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = {}
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Botão Adicionar"
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
private fun BarraDeNAvegacaoPreview() {
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
@Preview
@Composable
private fun HomeScreenPreview() {
    ClientesAppTheme {
        HomeScreen()
    }
}