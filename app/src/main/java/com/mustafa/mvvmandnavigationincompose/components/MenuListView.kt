package com.mustafa.mvvmandnavigationincompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mustafa.mvvmandnavigationincompose.navigation.NavigationItem
import com.mustafa.mvvmandnavigationincompose.viewModel.menuViewModel.MenuModel
import com.mustafa.mvvmandnavigationincompose.viewModel.menuViewModel.MenuRepository
import com.mustafa.mvvmandnavigationincompose.viewModel.menuViewModel.MenuViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuList(
    modifier: Modifier = Modifier,
    menuRepository: MenuRepository,
    navController: NavController
) {

    val menuViewModel = remember { MenuViewModel(menuRepository) }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(242, 233, 228)
    ) {
        Column {
            TopAppBar(
                title = {
                    Text(
                        text = "Menü",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(154, 140, 140, 255)
                ),
                actions = {
                    IconButton(onClick = { navController.navigate(NavigationItem.OrderList.route)}) {
                        Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "" )
                    }

                }
            )

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(10.dp)
            ) {
                items(menuViewModel.menuList.value ?: emptyList()) { menuItem ->
                    MenuListItem(
                        menuModel = menuItem,
                        navController = navController
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Composable
fun MenuListItem(
    menuModel: MenuModel,
    navController: NavController
) {
    MenuItemCard(menuModel = menuModel, navController = navController)
}

@Composable
fun MenuItemCard(
    modifier: Modifier = Modifier,
    menuModel: MenuModel,
    navController: NavController
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(209, 201, 193, 255)
        ),
        modifier = modifier
            .size(width = 380.dp, height = 150.dp)
            .clickable {
                navController.navigate(
                    NavigationItem.ContentList.withArgs(
                        menuModel.id.toString(),
                        menuModel.name
                    )
                )
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = menuModel.image),
                contentDescription = "",
                modifier = modifier
                    .size(width = 155.dp, height = 150.dp)
                    .padding(20.dp)
                    .clip(
                        CircleShape
                    )
            )
            Spacer(modifier = modifier.height(20.dp))

            Text(
                text = menuModel.name,
                modifier = modifier.padding(start = 30.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )

        }
    }
}