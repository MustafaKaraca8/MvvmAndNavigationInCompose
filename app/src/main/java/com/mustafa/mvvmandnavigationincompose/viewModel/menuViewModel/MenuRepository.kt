package com.mustafa.mvvmandnavigationincompose.viewModel.menuViewModel

import com.mustafa.mvvmandnavigationincompose.R

class MenuRepository {

    private val menuList = mutableListOf<MenuModel>()

    init {
        menuList.add(MenuModel(1 , R.drawable.soupe, "Çorbalar"))
        menuList.add(MenuModel(2 , R.drawable.food, "Ana Yemekler"))
        menuList.add(MenuModel(3 , R.drawable.drinks, "İçecekler"))
        menuList.add(MenuModel(4 , R.drawable.appetizer, "Mezeler"))
        menuList.add(MenuModel(5 , R.drawable.dessert, "Tatlılar"))
    }

    fun getMenuList() : List<MenuModel>{
        return menuList
    }
}