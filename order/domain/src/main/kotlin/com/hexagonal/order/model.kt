package com.hexagonal.order

import com.dreamStore.product.Product
import com.dreamstore.common.Price
import com.dreamstore.member.Member

class Order(
    val id: Long = 0L,
    val totalPrice: Price = Price(0),
    val member: Member,
    val orderEntryList: List<OrderEntry> = mutableListOf()
)

class OrderEntry(
    val id: Long = 0L,
    val price: Price,
    val product: Product,
    val quantity: Quantity,
)

class Quantity(
    val value: Int,
) {
    init {
        if (value <= 0) throw IllegalArgumentException()
    }
}