package com.mustafa.mvvmandnavigationincompose.navigation

enum class NavItems {
    MENU_LIST,
    CONTENT_LIST,
    CONTENT_DETAIL,
    ORDER_LIST,
    ORDER_SUCCESS_SCREEN
}

sealed class NavigationItem(val route: String) {
    data object MenuList : NavigationItem(NavItems.MENU_LIST.name)
    data object ContentList : NavigationItem(NavItems.CONTENT_LIST.name)
    data object ContentDetail : NavigationItem(NavItems.CONTENT_DETAIL.name)
    data object OrderList : NavigationItem(NavItems.ORDER_LIST.name)
    data object OrderSuccess : NavigationItem(NavItems.ORDER_SUCCESS_SCREEN.name)
    fun withArgs(vararg args : String) : String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}