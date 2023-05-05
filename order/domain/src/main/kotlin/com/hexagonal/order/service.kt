package com.hexagonal.order

import com.hexagonal.order.adaptor.out.OrderRepository
import com.hexagonal.order.dto.RegisterOrderRequest


class OrderService(
    private val orderRepository: OrderRepository,
    private val orderFactory: OrderFactory,
) {
    fun getOrders(): List<Order> {
        return orderRepository.findAll()
    }

    fun getOrder(id: Long): Order {
        return orderRepository.findById(id) ?: throw IllegalArgumentException("주문을 찾을 수 없습니다")
    }

    fun registerOrder(registerOrderRequest: RegisterOrderRequest) {
        orderFactory.createOrder(registerOrderRequest)
    }
}