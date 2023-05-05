package com.hexagonal.order.dto

class RegisterOrderRequest(
    val memberId: String,
    val products: List<CreateOrderEntryRequest>,
)

class CreateOrderEntryRequest(
    val productId: Long,
    val quantity: Int
)