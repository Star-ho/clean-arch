package com.dreamStore.domain.product

import com.dreamstore.common.Label
import com.dreamstore.common.Price

class Product(
    val id:Long=0,
    val label: Label,
    val price: Price
)