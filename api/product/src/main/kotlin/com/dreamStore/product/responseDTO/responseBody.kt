package com.dreamStore.product.responseDTO

import com.dreamStore.domain.product.dto.ProductDTO

class ProductResponse(productDTO: ProductDTO){
    val id=productDTO.id
    val label=productDTO.label
    val price=productDTO.price
}