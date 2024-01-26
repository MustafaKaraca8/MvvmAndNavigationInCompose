package com.mustafa.mvvmandnavigationincompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.mustafa.mvvmandnavigationincompose.navigation.NavigationItem
import com.mustafa.mvvmandnavigationincompose.ui.theme.MvvmAndNavigationInComposeTheme
import com.mustafa.mvvmandnavigationincompose.viewModel.orderViewModel.OrderRepository
import kotlinx.coroutines.delay

@Composable
fun OrderSuccessScreen(
    modifier : Modifier = Modifier,
    navController: NavController,
    orderRepository: OrderRepository
) {

    var isRedirecting by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = isRedirecting) {
        delay(2000)
        isRedirecting = true
    }


    if (isRedirecting) {
        navController.navigate(NavigationItem.MenuList.route)
        orderRepository.clearAllOrders()
    } else {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Green),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Sipariş Alındı",
                style = MaterialTheme.typography.displayLarge,
                color = Color.White
            )
        }
    }
}
