package com.mustafa.mvvmandnavigationincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mustafa.mvvmandnavigationincompose.navigation.Navigation
import com.mustafa.mvvmandnavigationincompose.ui.theme.MvvmAndNavigationInComposeTheme
import com.mustafa.mvvmandnavigationincompose.viewModel.contentViewModel.ContentRepository
import com.mustafa.mvvmandnavigationincompose.viewModel.menuViewModel.MenuRepository
import com.mustafa.mvvmandnavigationincompose.viewModel.orderViewModel.OrderRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MvvmAndNavigationInComposeTheme {
                val menuRepository = MenuRepository()
                val contentRepository = ContentRepository()
                val orderRepository = OrderRepository()
                Navigation(menuRepository = menuRepository, contentRepository = contentRepository , orderRepository = orderRepository)
            }
        }
    }
}
