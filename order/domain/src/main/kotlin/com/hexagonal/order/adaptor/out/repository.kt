package com.hexagonal.order.adaptor.out

import com.hexagonal.order.Order

interface OrderRepositoryAdaptor {
    fun findAll(): List<Order>
    fun findById(id: Long): Order
    fun save(order: Order)
}