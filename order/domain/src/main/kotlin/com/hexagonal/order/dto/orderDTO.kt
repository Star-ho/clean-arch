package com.hexagonal.order.dto

class RegisterOrderDTO(
    val memberId: String,
    val products: List<CreateOrderEntryRequest>,
)

class CreateOrderEntryRequest(
    val productId: Long,
    val quantity: Int
)