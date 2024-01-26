package com.mustafa.mvvmandnavigationincompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mustafa.mvvmandnavigationincompose.components.ContentDetails
import com.mustafa.mvvmandnavigationincompose.components.ContentList
import com.mustafa.mvvmandnavigationincompose.components.MenuList
import com.mustafa.mvvmandnavigationincompose.components.OrderList
import com.mustafa.mvvmandnavigationincompose.viewModel.contentViewModel.ContentRepository
import com.mustafa.mvvmandnavigationincompose.viewModel.menuViewModel.MenuRepository
import com.mustafa.mvvmandnavigationincompose.viewModel.orderViewModel.OrderRepository

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    startDestination: String = NavigationItem.MenuList.route,
    menuRepository: MenuRepository,
    contentRepository: ContentRepository,
    orderRepository : OrderRepository
) {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = startDestination) {

        composable(route = NavigationItem.MenuList.route) {
            MenuList(menuRepository = menuRepository, navController = navHostController)
        }
        composable(route = NavigationItem.ContentList.route + "/{id}/{menuName}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                },
                navArgument("menuName") {
                    type = NavType.StringType
                }
            )) { entry ->
            ContentList(
                contentRepository = contentRepository,
                navController = navHostController,
                id = entry.arguments?.getInt("id")!!,
                menuName = entry.arguments?.getString("menuName")!!
            )
        }

        composable(
            route = NavigationItem.ContentDetail.route + "/{image}/{foodName}/{price}",
            arguments = listOf(
                navArgument("image") {
                    type = NavType.IntType
                },
                navArgument("foodName") {
                    type = NavType.StringType
                },
                navArgument("price") {
                    type = NavType.IntType
                },
            )
        ) { entry ->
            ContentDetails(
                navController = navHostController,
                image = entry.arguments?.getInt("image")!!,
                foodName = entry.arguments?.getString("foodName")!!,
                price = entry.arguments?.getInt("price")!!,
                contentRepository = contentRepository,
                orderRepository = orderRepository
            )
        }

        composable(route = NavigationItem.OrderList.route){entry->
            OrderList(orderRepository = orderRepository, navController = navHostController)
        }
    }
}