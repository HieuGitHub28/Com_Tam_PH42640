package com.example.com_tam_ph42640

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.com_tam.repository.RepositoryUser
import com.example.com_tam_ph42640.database.AppDatabase
import com.example.com_tam_ph42640.model.LoaiMonAnViewModel
import com.example.com_tam_ph42640.model.MonAnViewModel
import com.example.com_tam_ph42640.repository.RepositoryLoaiMon
import com.example.com_tam_ph42640.repository.RepositoryMonAn
import com.example.com_tam_ph42640.ui.theme.screen.*

@Composable
fun NavApp() {
    val context = LocalContext.current
    val db = AppDatabase.getInstance(context)
    val repositoryLoaiMon = RepositoryLoaiMon(db)
    val loaiMonAnViewModel = LoaiMonAnViewModel(repositoryLoaiMon)
    val userRepository = RepositoryUser(db)
    val repositoryMonAn = RepositoryMonAn(db)
    val monAnViewModel = MonAnViewModel(repositoryMonAn)
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route,
    ) {
        composable(Screen.WelcomeScreen.route) { WelcomeScreen(navController) }
        composable(Screen.Sign_inScreen.route) {
            Sign_inScreen(navController, userRepository)
        }
        composable(Screen.LoginScreen.route) { LoginScreen(navController) }
        composable(Screen.SupportScreen.route) { HoTro() }
        composable(Screen.DeltailDHScreen.route) { XacNhanDonHang() }
        composable(Screen.ManagerScreen.route) { QuanLy(navController, loaiMonAnViewModel ) }
        composable(Screen.HomeScreen.route) { HomeScreen() }
        composable(Screen.HistoryScreen.route) { HistoryScreen() }
        composable(Screen.FurnitureApp.route) { FurnitureApp(navController,loaiMonAnViewModel) }
        composable(Screen.ProfileScreen.route) { ProfileScreen() }
        composable(Screen.EditProfileScreen.route) { EditProfileScreen() }
        composable(Screen.QuanLyLoaiMonAn.route) { QuanLyLoaiMonAn(navController, loaiMonAnViewModel) }
        composable(Screen.SuaLoaiMonAn.route) { SuaLoaiMonAn(viewModel = loaiMonAnViewModel,navController) }
        composable(Screen.XoaLoaiMonAn.route) { XoaLoaiMonAn(viewModel = loaiMonAnViewModel,navController) }
        composable(Screen.QuanLyMonAn.route) { QuanLyMonAn(navController) }
        composable(Screen.ThemMonAn.route) { AddMonAn(navController, viewModel =  monAnViewModel, loaiMonAnViewModel = loaiMonAnViewModel) }

    }
}
