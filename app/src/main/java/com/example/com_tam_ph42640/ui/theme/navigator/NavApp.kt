package com.example.com_tam_ph42640

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.com_tam_ph42640.ui.theme.screen.EditProfileScreen
import com.example.com_tam_ph42640.ui.theme.screen.ProfileScreen


@Composable
fun NavApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route,
    ) {
        composable(Screen.WelcomeScreen.route) { WelcomeScreen(navController) }
        composable(Screen.LoginScreen.route) { LoginScreen(navController) }
        composable(Screen.Sign_inScreen.route) { Sign_inScreen(navController) }
        composable(Screen.SupportScreen.route) { HoTro() }
        composable(Screen.DeltailDHScreen.route) { XacNhanDonHang() }
        composable(Screen.ManagerScreen.route) { QuanLy() }
        composable(Screen.HomeScreen.route) { HomeScreen() }
        composable(Screen.HistoryScreen.route) { HistoryScreen() }
        composable(Screen.FurnitureApp.route) { FurnitureApp(navController) }
        composable(Screen.ProfileScreen.route) { ProfileScreen(navController) }
        composable(Screen.EditProfileScreen.route) { EditProfileScreen(navController) }

    }
}