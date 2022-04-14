package com.dreamStore.product.requstDTO

import com.dreamStore.domain.product.dto.CreateProductDto
import java.math.BigDecimal

class RegisterProductRequest(
    val label:String="",
    val price:BigDecimal=BigDecimal.ZERO
){
    fun toDto()=CreateProductDto(label = label,price = price)
}