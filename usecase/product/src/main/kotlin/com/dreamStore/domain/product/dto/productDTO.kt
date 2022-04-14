package com.dreamStore.domain.product.dto

import com.dreamStore.domain.product.data.ProductData
import java.math.BigDecimal

class CreateProductDto(
    val label:String,
    val price: BigDecimal
)

class ProductDTO( val id:Long=0,
                  val label: String,
                  val price: BigDecimal){
    constructor(productData:ProductData):this(
        productData.id,
        productData.label,
        productData.price
    )
}
