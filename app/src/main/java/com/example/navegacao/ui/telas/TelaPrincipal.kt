package com.example.navegacao.ui.telas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaPrincipal(modifier: Modifier = Modifier, onLogoffClick: () -> Unit) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.92f)),

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(
                onClick = { onLogoffClick() }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }

            IconButton(
                onClick = { onLogoffClick() }
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Usuário",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(56.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Hello Peter",
                    color = Color.White,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    ),
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                Text(
                    text = "Welcome back!",
                    color = Color.Gray,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp
                    )
                )
            }

            Column {
                IconButton(
                    onClick = { /* Ação do ícone de equalização */ },
                    modifier = Modifier.background(Color.Black.copy(alpha = 0.1f), shape = RoundedCornerShape(16.dp))
                ) {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Equalizer",
                        tint = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // First column
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                PastelCard(color = Color(0xFFD1F8F3), text = "Card 1", height = 210.dp, icon = Icons.Filled.Build, number = "230k", description = "Reprocessados")
                PastelCard(color = Color(0xFFDAD6D3), text = "Card 2", height = 230.dp, icon = Icons.Filled.Notifications, number = "8.549k", description = "Pendentes")
            }

            // Second column
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                PastelCard(color = Color(0xFFE7DEF1), text = "Card 3", height = 230.dp, icon = Icons.Filled.FavoriteBorder, number = "1.423k", description = "Concluídos")
                PastelCard(color = Color(0xFFF1DFDF), text = "Card 4", height = 210.dp, icon = Icons.Filled.DateRange, number = "300", description = "Aguardando")
            }
        }
    }
}

@Composable
fun PastelCard(color: Color, text: String, height: Dp, icon: ImageVector, number: String, description: String,) {
    Card(
        colors = CardDefaults.cardColors(containerColor = color),
        shape = RoundedCornerShape(28.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.height(20.dp)
            )
            Text(
                text = number,
                color = Color.Black,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                modifier = Modifier.padding(top = 32.dp, bottom = 8.dp)
            )
            Text(
                text = description,
                color = Color.Black,

                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            )
        }
    }
}