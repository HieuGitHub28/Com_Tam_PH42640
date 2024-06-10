package com.example.com_tam_ph42640.ui.theme.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.com_tam_ph42640.R
import com.example.com_tam_ph42640.LoaiMonAnModel
import com.example.com_tam_ph42640.Screen
import com.example.com_tam_ph42640.model.LoaiMonAnViewModel

@Composable
fun QuanLyLoaiMonAn(navController: NavController, myViewModel: LoaiMonAnViewModel) {
    val context = LocalContext.current
    var itShowDiaLog by remember { mutableStateOf(false) }

    if (itShowDiaLog) {
        getDialog(viewModel = myViewModel, onConfirmation = { itShowDiaLog = false }, context)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121)),
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Divider(
                color = Color.Black,
                thickness = 3.dp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(18.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clickable {
                        itShowDiaLog = true
                    },
                contentAlignment = Alignment.TopStart
            ) {
                Row(
                    modifier = Modifier
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logo2),
                        contentDescription = null,
                        modifier = Modifier
                            .width(70.dp)
                            .height(58.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Thêm loại món ăn",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clickable {
                        navController.navigate(
                            route = Screen.SuaLoaiMonAn.route
                        )
                    }
                    ,
                contentAlignment = Alignment.TopStart
            ) {
                Row(
                    modifier = Modifier
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logo2),
                        contentDescription = null,
                        modifier = Modifier
                            .width(70.dp)
                            .height(58.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Sửa loại món ăn",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clickable {
                        navController.navigate(Screen.XoaLoaiMonAn.route)
                    }
                   ,
                contentAlignment = Alignment.TopStart
            ) {
                Row(
                    modifier = Modifier
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.logo2),
                        contentDescription = null,
                        modifier = Modifier
                            .width(70.dp)
                            .height(58.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Xóa loại món ăn",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun getDialog(viewModel: LoaiMonAnViewModel, onConfirmation: () -> Unit, context: Context) {
    var inputTenLoaiMonAn by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { },
        dismissButton = {
            Button(onClick = {
                onConfirmation()
                inputTenLoaiMonAn = ""
            }) {
                Text(text = "Cancel")
            }
        },
        confirmButton = {
            Button(onClick = {
                if (inputTenLoaiMonAn.isNotEmpty()) {
                    viewModel.addLoaiMonAn(
                        LoaiMonAnModel(
                            0,
                            inputTenLoaiMonAn
                        )
                    )
                    Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show()
                }
                onConfirmation()
                inputTenLoaiMonAn = ""
            }) {
                Text(text = "Save")
            }
        },
        title = {
            Text(
                text = "Thêm loại món ăn",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier.padding(5.dp)
            )
        },
        text = {
            Column {
                OutlinedTextField(
                    value = inputTenLoaiMonAn,
                    onValueChange = { inputTenLoaiMonAn = it },
                    label = { Text(text = "Tên loại món") },
                    placeholder = { Text(text = "Nhập tên loại món") }
                )
            }
        }
    )
}
