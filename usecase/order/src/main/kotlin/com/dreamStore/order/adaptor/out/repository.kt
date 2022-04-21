package com.dreamStore.order.adaptor.out

import com.dreamStore.order.Order

interface OrderRepositoryAdaptor {
    fun findAll(): List<Order>
}