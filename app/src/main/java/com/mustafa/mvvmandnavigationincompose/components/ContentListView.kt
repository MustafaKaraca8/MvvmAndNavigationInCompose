package com.mustafa.mvvmandnavigationincompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mustafa.mvvmandnavigationincompose.R
import com.mustafa.mvvmandnavigationincompose.navigation.NavigationItem
import com.mustafa.mvvmandnavigationincompose.viewModel.contentViewModel.ContentModel
import com.mustafa.mvvmandnavigationincompose.viewModel.contentViewModel.ContentRepository
import com.mustafa.mvvmandnavigationincompose.viewModel.contentViewModel.ContentViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentList(
    modifier: Modifier = Modifier,
    contentRepository: ContentRepository,
    navController: NavController,
    id: Int,
    menuName: String
) {

    val contentViewModel = remember { ContentViewModel(contentRepository, id) }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(242, 233, 228)
    ) {
        Column {
            TopAppBar(
                title = {
                    Text(
                        text = "$menuName Menüsü",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(154, 140, 140, 255)
                ), navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack(
                            route = NavigationItem.MenuList.route,
                            inclusive = false
                        )
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }
            )

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(10.dp)
            ) {
                items(contentViewModel.contentList.value ?: emptyList()) { contentItem ->
                    ContentListItem(
                        contentModel = contentItem,
                        navController = navController,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }

}

@Composable
fun ContentListItem(
    contentModel: ContentModel,
    navController: NavController,
) {
    ContentItemCard(
        contentModel = contentModel,
        navController = navController,
    )
}

@Composable
fun ContentItemCard(
    modifier: Modifier = Modifier,
    contentModel: ContentModel,
    navController: NavController,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(209, 201, 193, 255)
        ),
        modifier = modifier
            .size(width = 380.dp, height = 150.dp)
            .clickable {
                navController.navigate(
                    route = NavigationItem.ContentDetail.withArgs(
                        contentModel.image.toString(),
                        contentModel.name,
                        contentModel.price.toString()))
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = contentModel.image),
                contentDescription = "",
                modifier = modifier
                    .size(width = 155.dp, height = 150.dp)
                    .padding(20.dp)
                    .clip(
                        CircleShape
                    )
            )
            Spacer(modifier = modifier.height(20.dp))

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = modifier.fillMaxWidth()
            ) {
                Text(
                    text = contentModel.name,
                    modifier = modifier.padding(start = 30.dp),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )

                Spacer(modifier = modifier.height(10.dp))

                Text(
                    text = "Fiyatı: ${contentModel.price} TL",
                    modifier = modifier
                        .align(alignment = Alignment.End)
                        .padding(end = 10.dp),
                    fontWeight = FontWeight.SemiBold
                )
            }

        }
    }
}