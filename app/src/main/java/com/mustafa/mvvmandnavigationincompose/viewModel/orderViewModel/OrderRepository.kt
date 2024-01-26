package com.mustafa.mvvmandnavigationincompose.viewModel.orderViewModel

class OrderRepository {

    private var listOfOrders = mutableListOf<OrderModel>()

    fun addOrder(orderModel: OrderModel) {
        listOfOrders.add(orderModel)
    }

    fun getOrders(): List<OrderModel> {
        return listOfOrders
    }
}