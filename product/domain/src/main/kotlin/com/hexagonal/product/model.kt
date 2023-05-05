package com.hexagonal.product

import com.hexagonal.common.Label
import com.hexagonal.common.Price


class Product(
    val id: Long = 0,
    val label: Label,
    val price: Price
)