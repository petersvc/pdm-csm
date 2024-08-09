package com.example.navegacao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navegacao.ui.telas.TelaCadastro
import com.example.navegacao.ui.telas.TelaLogin
import com.example.navegacao.ui.telas.TelaPrincipal
import com.example.navegacao.ui.theme.NavegacaoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacaoTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        if (bottomBarVisible(navController)) {
                            BottomAppBar(
                                containerColor = Color.Black.copy(alpha = 0.92f),
                                contentColor = Color.White,
                            ) {

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    IconButton(onClick = { navController.navigate("main") }) {
                                        Icon(
                                            imageVector = Icons.Filled.Home,
                                            contentDescription = "Main",
                                            tint = Color.White
                                        )
                                    }

                                    IconButton(onClick = { /* Ação para o ícone 2 */ }) {
                                        Icon(
                                            imageVector = Icons.Filled.Favorite,
                                            contentDescription = "Favorite",
                                            tint = Color.White
                                        )
                                    }

                                    IconButton(onClick = { /* Ação para o ícone 3 */ }) {
                                        Icon(
                                            imageVector = Icons.Filled.Search,
                                            contentDescription = "Search",
                                            tint = Color.White
                                        )
                                    }

                                    IconButton(onClick = { navController.navigate("profile") }) {
                                        Icon(
                                            imageVector = Icons.Filled.Person,
                                            contentDescription = "Profile",
                                            tint = Color.White
                                        )
                                    }
                                }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController = navController, startDestination = "main") {
                        composable("login") {
                            TelaLogin(
                                modifier = Modifier.padding(innerPadding),
                                onSignInClick = {
                                    navController.navigate("main")
                                },
                                onSignUpClick = {
                                    navController.navigate("signup")
                                }
                            )
                        }
                        composable("signup") {
                            TelaCadastro(
                                modifier = Modifier.padding(innerPadding),
                                onSignUpClick = {
                                    navController.navigate("login")
                                },
                                onSignInClick = {
                                    navController.navigate("login")
                                }
                            )
                        }
                        composable("main") {
                            TelaPrincipal(modifier = Modifier.padding(innerPadding), onLogoffClick = {
                                navController.navigate("login")
                            })
                        }

                    }

                }
            }
        }
    }
}

@Composable
fun bottomBarVisible(navController: NavController): Boolean {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    return currentRoute != "login" && currentRoute != "signup"
}