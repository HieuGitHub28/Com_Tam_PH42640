package com.example.com_tam_ph42640.ui.theme.screen

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.com_tam_ph42640.InputField
import com.example.com_tam_ph42640.Screen
import com.example.com_tam_ph42640.R


@Composable
fun ProfileScreen(navController: NavController) {
    var isShowdialog by remember {
        mutableStateOf(false)
    }
    if (isShowdialog) ShowDialog(onConfirmation = { isShowdialog = false }, navController)
Column(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
    horizontalAlignment =  Alignment.CenterHorizontally,
) {
    Text(text = "Hồ sơ",
        fontWeight = FontWeight(800),
        fontSize = 24.sp,
        color = Color.White,
        modifier = Modifier.padding(top = 70.dp)
    )
    
    Row(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(top = 15.dp)
            .height(80.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Edit",
        fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.clickable {
                navController.navigate(
                    route = Screen.EditProfileScreen.route)
            }
            )
        
        Spacer(modifier = Modifier.height(20.dp))
        
        Text(text = "Signout",
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.clickable {
                isShowdialog = true
            })
    }
    
    Spacer(modifier = Modifier.height(30.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(color = Color("#252121".toColorInt())),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .padding(0.dp, 70.dp, 0.dp, 0.dp)
        ) {
            Text(text = "Van Anh",
                color = Color.White,
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputField(label = "Số điện thoại", value = "", onValueChange = {})
            InputField(label = "Phường", value = "", onValueChange = {})
            InputField(label = "Đường", value = "", onValueChange = {})
            InputField(label = "Số nhà", value = "", onValueChange = {})
        }
    }
}
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logosplash), contentDescription = "",
            modifier = Modifier
                .size(130.dp)
                .border(12.dp, Color.White, RoundedCornerShape(140.dp)),
            contentScale = ContentScale.Inside)
    }
}

@Composable
fun ShowDialog(
    onConfirmation: () -> Unit,
    navController: NavController
) {

    Dialog(onDismissRequest = {}) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text("Xác nhận", style =
                MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(20.dp))
                Text("Bạn có muốn đăng xuất không?", style =
                MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    Modifier.fillMaxWidth()
                ){
                    Button(
                        onClick = onConfirmation,
                        modifier = Modifier
                            .padding(10.dp)
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.DarkGray,
                            contentColor = Color.White
                        )
                    ) {
                        Text("Cancel")
                    }

                    Button(
                        onClick = {
                            onConfirmation()
                            navController.navigate(Screen.LoginScreen.route){
                                popUpTo(Screen.FurnitureApp.route){
                                    inclusive = true
                                }
                            }
                                  }
                        ,
                        modifier = Modifier
                            .padding(10.dp)
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.DarkGray,
                            contentColor = Color.White
                        )
                    ) {
                        Text("OK")
                    }
                }
            }
        }
    }
}