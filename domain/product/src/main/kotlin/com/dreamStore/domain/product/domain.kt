package com.dreamStore.domain.product

import java.math.BigDecimal

class Product(
    val id:Long=0,
    val label:String,
    val price:BigDecimal
)