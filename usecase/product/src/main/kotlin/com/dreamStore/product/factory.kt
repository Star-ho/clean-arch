package com.dreamStore.product

import com.dreamStore.domain.product.adaptor.out.ProductRepositoryAdaptor
import com.dreamStore.domain.product.dto.CreateProductDto
import com.dreamStore.domain.product.dto.ProductDTO
import org.springframework.stereotype.Component

@Component
class ProductFactory(
    private val productRepository:ProductRepositoryAdaptor
) {
    fun getProduct(id:Long): ProductDTO? {
        return productRepository.findById(id)
    }

    fun registerProduct(createProductDto: CreateProductDto){
        productRepository.save(createProductDto)
    }
}