package com.hexagonal.product.request

import com.hexagonal.product.dto.CreateProductDto


class RegisterProductRequest(
    val label: String,
    val price: Int,
) {
    fun toDto() = CreateProductDto(label = label, price = price)
}