package com.dreamStore.domain.product.dto

import java.math.BigDecimal

class CreateProductDto(
    val label:String,
    val price: BigDecimal
)

class ProductDTO( val id:Long=0,
                  val label: String,
                  val price: BigDecimal){
}
