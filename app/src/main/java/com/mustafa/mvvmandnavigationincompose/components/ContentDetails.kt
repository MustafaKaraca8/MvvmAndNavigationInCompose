package com.mustafa.mvvmandnavigationincompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mustafa.mvvmandnavigationincompose.navigation.NavigationItem
import com.mustafa.mvvmandnavigationincompose.viewModel.contentViewModel.ContentRepository
import com.mustafa.mvvmandnavigationincompose.viewModel.orderViewModel.OrderModel
import com.mustafa.mvvmandnavigationincompose.viewModel.orderViewModel.OrderRepository


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentDetails(
    modifier: Modifier = Modifier,
    navController: NavController,
    contentRepository: ContentRepository,
    orderRepository : OrderRepository,
    image: Int,
    foodName: String,
    price: Int,
) {
    var orderCount by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(190, 183, 183, 255)),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = foodName,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(154, 140, 140, 255)
            ), navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        )

        Spacer(modifier = modifier.height(70.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Food Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Fiyatı: $price",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )


        StepperButton(
            value = orderCount,
            price = price,
            onIncrease = { orderCount++ },
            onDecrease = { if (orderCount > 0) orderCount-- })

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (orderCount > 0){
                    navController.navigate(NavigationItem.MenuList.route)
                    orderRepository.addOrder(OrderModel(image = image , foodName = foodName , count = orderCount , totalPrice = price * orderCount))

                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(70, 125, 189, 255))
        ) {
            Text(
                text = "Sipariş Ver",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}
