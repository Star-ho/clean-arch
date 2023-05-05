package com.hexagonal.order.adaptor.out

import com.hexagonal.order.Order

interface OrderRepository {
    fun findAll(): List<Order>
    fun findById(id: Long): Order?
    fun save(order: Order)
}
