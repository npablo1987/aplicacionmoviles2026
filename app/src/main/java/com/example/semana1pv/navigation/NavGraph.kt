package com.example.semana1pv.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.semana1pv.ui.screens.HomeUserScreen
import com.example.semana1pv.ui.screens.LoginScreen
import com.example.semana1pv.ui.screens.RegistroScreen
import com.example.semana1pv.ui.screens.SpashScreen

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Registro : Screen("registro")
    object Splash : Screen("splash")
    object HomeUser : Screen("homeUser")
}

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route)
        {
        composable(Screen.Splash.route){
            SpashScreen(
                    onStartClick = {
                        navController.navigate(Screen.Login.route){
                            popUpTo(Screen.Splash.route){
                                inclusive = true
                            }
                        }
                    }
                )
        }
        composable(Screen.Login.route){
            LoginScreen(
                onRegistroClick = {
                    navController.navigate(Screen.Registro.route)
                },
                onLoginSuccess = {
                    navController.navigate(Screen.HomeUser.route)
                }
            )
        }

        composable(Screen.Registro.route){
            RegistroScreen(
                onLoginClick = {
                    navController.navigate(Screen.Login.route)
                },
                onRegistroClick = {
                    navController.navigate(Screen.Registro.route)
                }
            )
        }

        composable(Screen.HomeUser.route){
            HomeUserScreen()
        }

        }
    }


