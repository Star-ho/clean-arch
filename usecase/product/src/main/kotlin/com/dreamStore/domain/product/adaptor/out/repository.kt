package com.dreamStore.domain.product.adaptor.out

import com.dreamStore.domain.product.dto.CreateProductDto
import com.dreamStore.domain.product.dto.ProductDTO

interface ProductRepositoryAdaptor{
    fun findAll():List<ProductDTO>
    fun findById(id:Long):ProductDTO?
    fun save(createProductDto: CreateProductDto)
}