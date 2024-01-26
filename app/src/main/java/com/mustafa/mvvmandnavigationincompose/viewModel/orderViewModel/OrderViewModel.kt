package com.mustafa.mvvmandnavigationincompose.viewModel.orderViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel(private val orderRepository: OrderRepository) : ViewModel() {

    private val _orderList = MutableLiveData<List<OrderModel>>()
    val orderList : LiveData<List<OrderModel>> = _orderList

    init {
        loadOrders()
    }

    fun addOrder(orderModel: OrderModel) {
        orderRepository.addOrder(orderModel)

        loadOrders()
    }

    private fun loadOrders() {
        _orderList.value = orderRepository.getOrders()
    }
}