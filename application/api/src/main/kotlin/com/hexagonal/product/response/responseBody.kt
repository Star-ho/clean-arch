package com.hexagonal.product.response

import com.hexagonal.product.Product

class ProductResponse(product: Product) {
    val id = product.id
    val label = product.label.value
    val price = product.price.value
}