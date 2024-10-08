package com.example.navegacao.ui.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.navegacao.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLogin(modifier: Modifier = Modifier, onSignInClick: () -> Unit, onSignUpClick: () -> Unit) {
    var login by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var mensagemErro by remember { mutableStateOf<String?>(null) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(Color.Gray.copy(alpha = 0.1f))
                .padding(top = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logoapp),
                contentDescription = "Descrição do ícone",
                modifier = Modifier.size(80.dp)
                    .graphicsLayer(alpha = 0.4f) // Ajusta a opacidade da imagem

            )
        }

        Spacer(modifier = Modifier.height(100.dp))

        TextField(
            value = login,
            onValueChange = { login = it },
            placeholder = {
                Text(
                    text = "Email",
                    style = TextStyle(fontWeight = FontWeight.Medium, color = Color.Gray.copy(alpha = 0.8f))
                )
            },
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Gray.copy(alpha = 0.15f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        TextField(
            value = senha,
            onValueChange = { senha = it },
            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                Text(
                    text = "Password",
                    style = TextStyle(fontWeight = FontWeight.Medium, color = Color.Gray.copy(alpha = 0.8f))
                )
            },
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Gray.copy(alpha = 0.15f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Esqueceu a senha?",
            color = Color(0xFF00704A).copy(alpha = 0.7f),
            textAlign = androidx.compose.ui.text.style.TextAlign.End,
            modifier = Modifier
                .fillMaxWidth(),
            style = TextStyle(
                fontWeight = FontWeight.Bold
            ),
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                if (login == senha) {
                    onSignInClick()
                } else {
                    mensagemErro = "Login ou senha inválidos!"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00704A))
        ) {
            Text("LOGIN", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        mensagemErro?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 8.dp)
            )
            LaunchedEffect(Unit) {
                delay(3000)
                mensagemErro = null
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account? ",
                color = Color.Gray,
                style = TextStyle(fontWeight = FontWeight.Normal),
            )
            Text(
                text = "Sign up",
                color = Color(0xFF00704A), // Cor verde do Starbucks
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .clickable { onSignUpClick() }
            )
        }

    }
}
