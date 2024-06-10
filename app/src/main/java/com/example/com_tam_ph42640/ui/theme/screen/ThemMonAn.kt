package com.example.com_tam_ph42640.ui.theme.screen

import android.content.Context
import android.content.pm.LauncherApps
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.com_tam_ph42640.R
import com.example.com_tam_ph42640.model.LoaiMonAnViewModel
import com.example.com_tam_ph42640.model.MonAnViewModel

import okhttp3.internal.http2.Header

@Composable
fun AddMonAn(navController: NavController, viewModel: MonAnViewModel, loaiMonAnViewModel: LoaiMonAnViewModel){

    val context = LocalContext.current
    val loaiMons by loaiMonAnViewModel.loaiMonAns.collectAsState(initial = emptyList())
    var selectLoaiMon by remember {
        mutableStateOf("")
    }
    var inputGia by remember {
        mutableStateOf("")
    }
    var inputTenMon by remember {
        mutableStateOf("")
    }
    var onMsg by remember {
        mutableStateOf("")
    }

    // chon loai mon
    var isDropdownMenuOpen by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }

    // chon anh
    val selectedImageUri = remember { mutableStateOf<Uri?>(null) }
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ) { uri: Uri? ->
        selectedImageUri.value = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121))
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(0.dp, 30.dp)
                .fillMaxWidth()
                .height(200.dp)
                .align(Alignment.CenterHorizontally)

        ) {
            // Hiển thị hình ảnh đã chọn (nếu có)
            selectedImageUri.value?.let { imageUri ->
                Image(
                    painter = rememberImagePainter(imageUri),
                    contentDescription = "Selected Image",
                    modifier = Modifier
                        .size(250.dp, 250.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .clickable {
                            openImagePicker(context, imagePickerLauncher)
                        },
                    contentScale = ContentScale.Crop
                )
            } ?: run{
                Column(
                        verticalArrangement = Arrangement.Center
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .size(250.dp, 250.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .clickable {
                            openImagePicker(context, imagePickerLauncher)
                        }
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")
                    Text(text = "Thêm hình ảnh")
                }
            }
        }

        Column(
            Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Loại mon", color = Color.White)
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = selectLoaiMon,
                onValueChange = {},
                readOnly = true, // Vô hiệu hóa tính năng chỉnh sửa
                trailingIcon = {
                    Icon(Icons.Default.KeyboardArrowDown,
                        contentDescription = "",
                        Modifier
                            .clickable {
                                isDropdownMenuOpen = true
                            }
                            .size(25.dp))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                ,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color("#E0E0E0".toColorInt()),
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                )
            )

            DropdownMenu(
                expanded = isDropdownMenuOpen,
                onDismissRequest = { isDropdownMenuOpen = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                loaiMons.forEach { loaiMon ->
                    DropdownMenuItem(
                        text = {
                            Text(text = loaiMon.tenLoaiMon.toString())
                        },
                        onClick = {
                        selectedItem = loaiMon.id.toString()
                        selectLoaiMon = loaiMon.tenLoaiMon.toString() // Lấy name của LoaiMon
                        isDropdownMenuOpen = false
                    })
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Gia", color = Color.White)
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = inputGia,
                onValueChange = { inputGia = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color("#E0E0E0".toColorInt()),
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Ten mon an", color = Color.White)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = inputTenMon,
                onValueChange = { inputTenMon = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color("#E0E0E0".toColorInt()),
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                )
            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(onClick = {
                    onMsg = viewModel.addMonAn(inputTenMon, inputGia, selectedItem, selectedImageUri.value.toString())
                    Toast.makeText(context,onMsg,Toast.LENGTH_SHORT).show()
                    if(onMsg.equals("Them thanh cong")){
                        inputGia = ""
                        inputTenMon = ""
                        selectLoaiMon = ""
                        selectedImageUri.value = null
                    }
                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFB703)
                    ),
                    modifier = Modifier.size(160.dp,40.dp)) {
                    Text(text = "Them", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    }



}


// Mở màn hình thư viện hình ảnh khi nhấp vào "Thêm hình ảnh"
fun openImagePicker(context: Context, imagePickerLauncher : ActivityResultLauncher<String>) {
    imagePickerLauncher.launch("image/*")
}

