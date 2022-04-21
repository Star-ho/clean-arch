package com.dreamStore.product.dto

import com.dreamStore.product.Product
import com.dreamstore.common.Label
import com.dreamstore.common.Price

class CreateProductDto(
    val label:String,
    val price: Int,
){

    fun toEntity(): Product {
        return Product(label = Label(label), price = Price(price))
    }
}
