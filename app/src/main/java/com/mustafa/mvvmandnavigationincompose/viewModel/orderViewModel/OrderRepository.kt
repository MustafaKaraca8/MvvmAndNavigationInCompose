package com.mustafa.mvvmandnavigationincompose.viewModel.orderViewModel

class OrderRepository {

    private var listOfOrders = mutableListOf<OrderModel>()
    private var totalOrderPrice : Int = 0

    fun addOrder(orderModel: OrderModel) {
        listOfOrders.add(orderModel)
        totalOrderPrice += orderModel.totalPrice
        println(totalOrderPrice)
    }

    fun getOrders(): List<OrderModel> {
        return listOfOrders
    }

    fun getTotalOrderPrice() : Int {
        return totalOrderPrice
    }
    fun clearAllOrders() {
        listOfOrders.clear()
        totalOrderPrice = 0
    }

}