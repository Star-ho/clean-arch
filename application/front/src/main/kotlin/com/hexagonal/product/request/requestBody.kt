package com.dreamStore.product.request

import com.dreamStore.product.dto.CreateProductDto
import java.math.BigDecimal

class RegisterProductRequest(
    val label: String,
    val price: Int,
) {
    fun toDto() = CreateProductDto(label = label, price = price)
}