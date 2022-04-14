package com.dreamStore.domain.product

import java.math.BigDecimal

class Product(
    val id:Long?=null,
    val label:String,
    val price:BigDecimal
){
    constructor(label:String,price: BigDecimal):this(null,label,price)
}