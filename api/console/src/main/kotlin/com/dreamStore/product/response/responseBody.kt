package com.dreamStore.product.response

import com.dreamStore.product.Product

class ProductResponse(product: Product){
    val id=product.id
    val label=product.label
    val price=product.price
}