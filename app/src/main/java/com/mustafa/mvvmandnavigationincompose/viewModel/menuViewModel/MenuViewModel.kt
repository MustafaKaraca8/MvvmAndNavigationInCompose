package com.mustafa.mvvmandnavigationincompose.viewModel.menuViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel(private val menuRepository: MenuRepository) : ViewModel() {

    private val _menuList = MutableLiveData<List<MenuModel>>()
    val menuList : LiveData<List<MenuModel>> =  _menuList

    init {
        _menuList.value = menuRepository.getMenuList()
    }
}