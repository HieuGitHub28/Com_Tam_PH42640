package com.example.com_tam_ph42640

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class HistoryOrder(
    val status: String,
    val date: String,
    val time: String,
    val itemCount: String,
    val price: String
)

@Composable
fun HistoryScreen() {
    val orders = listOf(
        HistoryOrder("Đơn hàng đã chấp nhận", "10/03/2023", "9:20", "3 món", "98k"),
        HistoryOrder("Đơn hàng đã bị huỷ", "10/03/2023", "9:20", "3 món", "98k"),
        HistoryOrder("Đơn hàng đã bị huỷ", "10/03/2023", "9:20", "3 món", "98k"),
        HistoryOrder("Đơn hàng đã được giao", "10/03/2023", "9:20", "3 món", "98k"),
        HistoryOrder("Đơn hàng đã được giao", "10/03/2023", "9:20", "3 món", "98k"),
        HistoryOrder("Đơn hàng đã được giao", "10/03/2023", "9:20", "3 món", "98k"),
        HistoryOrder("Đơn hàng đã được giao", "10/03/2023", "9:20", "3 món", "98k")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF252121))
            .padding(16.dp)
    ) {
        Text(
            text = "Lịch sử",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        LazyColumn {
            items(orders) { order ->
                HistoryOrderItem(order)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun HistoryOrderItem(order: HistoryOrder) {
    val statusColor = when {
        order.status.contains("huỷ") -> Color.Red
        order.status.contains("giao") -> Color.Green
        else -> Color.White
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .padding(16.dp)
        ) {
            Text(
                text = order.status,
                color = statusColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${order.date}  ${order.time}",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = order.itemCount,
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                    Text(
                        text = order.price,
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}
