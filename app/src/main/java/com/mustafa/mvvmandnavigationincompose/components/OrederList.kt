package com.mustafa.mvvmandnavigationincompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mustafa.mvvmandnavigationincompose.ui.theme.MvvmAndNavigationInComposeTheme
import com.mustafa.mvvmandnavigationincompose.viewModel.contentViewModel.ContentRepository
import com.mustafa.mvvmandnavigationincompose.viewModel.contentViewModel.ContentViewModel
import com.mustafa.mvvmandnavigationincompose.viewModel.orderViewModel.OrderModel
import com.mustafa.mvvmandnavigationincompose.viewModel.orderViewModel.OrderRepository
import com.mustafa.mvvmandnavigationincompose.viewModel.orderViewModel.OrderViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderList(
    modifier: Modifier = Modifier,
    orderRepository: OrderRepository,
    navController: NavController
) {

    val orderViewModel = remember { OrderViewModel(orderRepository) }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(242, 233, 228)
    ) {
        Column {
            TopAppBar(
                title = {
                    Text(
                        text = "Sipariş Listesi",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(154, 140, 140, 255)
                ),
            )

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(10.dp)
            ) {
                items(orderViewModel.orderList.value ?: emptyList()) { orderItem ->
                    OrderItemCard(
                        orderModel = orderItem
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }

}

@Composable
fun OrderItemCard(
    modifier: Modifier = Modifier,
    orderModel: OrderModel,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(209, 201, 193, 255)
        ),
        modifier = modifier
            .size(width = 380.dp, height = 150.dp),

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = orderModel.image),
                contentDescription = "",
                modifier = modifier
                    .size(width = 155.dp, height = 150.dp)
                    .padding(20.dp)
                    .clip(
                        CircleShape
                    )
            )
            Box(
                modifier = modifier.size(width = 120.dp, height = 50.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = orderModel.foodName,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,

                    )
            }


            Spacer(modifier = modifier.padding(start = 4.dp))
            Column {
                Text(
                    text = "Adet: ${orderModel.count}",
                    modifier = modifier
                        .padding(end = 10.dp),
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "Tutar: ${orderModel.totalPrice} TL",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

        }


    }
}

@Preview(showSystemUi = true)
@Composable
fun OrderListPreview() {
    MvvmAndNavigationInComposeTheme {

    }
}