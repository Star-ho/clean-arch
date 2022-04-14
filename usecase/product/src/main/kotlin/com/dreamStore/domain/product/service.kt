package com.dreamStore.domain.product

import com.dreamStore.domain.product.data.ProductData
import com.dreamStore.domain.product.data.ProductRepository
import com.dreamStore.domain.product.dto.CreateProductDto
import com.dreamStore.domain.product.dto.ProductDTO
import org.springframework.stereotype.Component

@Component
class ProductService(
    private val productFactory: ProductFactory,
    private val productRepository: ProductRepository,
) {
    fun getProductList(): List<ProductDTO> {
        return productRepository.findAll().map { ProductDTO(it) }

    }
    fun registerProduct(createProductDto: CreateProductDto){
        productFactory.registerProduct(createProductDto)
    }
}