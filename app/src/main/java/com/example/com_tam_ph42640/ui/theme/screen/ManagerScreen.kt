package com.example.com_tam_ph42640

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun QuanLy() {
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
                    .height(70.dp)
                    .clickable {

                    },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.padding(15.dp))
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
                        text = "Quản lý loại món ăn",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Box(
                modifier = Modifier
                    .height(70.dp)
                    .clickable {

                    },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.padding(15.dp))
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
                        text = "Quản lý món ăn",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

        }
    }
}