package com.dreamStore.domain.product

import com.dreamStore.domain.product.adaptor.out.ProductRepositoryAdaptor
import com.dreamStore.domain.product.dto.CreateProductDto
import com.dreamStore.domain.product.dto.ProductDTO
import org.springframework.stereotype.Component

@Component
class ProductService(
    private val productFactory: ProductFactory,
    private val productRepositoryAdaptor: ProductRepositoryAdaptor,
) {
    fun getProductList(): List<ProductDTO> {
        return productRepositoryAdaptor.findAll()

    }
    fun registerProduct(createProductDto: CreateProductDto){
        productFactory.registerProduct(createProductDto)
    }
}