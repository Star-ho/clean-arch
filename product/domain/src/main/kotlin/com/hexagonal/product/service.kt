package com.hexagonal.product

import com.hexagonal.product.adaptor.out.ProductRepository
import com.hexagonal.product.dto.CreateProductDto
import org.springframework.stereotype.Component

@Component
class ProductService(
    private val productFactory: ProductFactory,
    private val productRepository: ProductRepository,
) {
    fun getProductList(): List<Product> {
        return productRepository.findAll()
    }

    fun getProduct(id: Long): Product {
        return productRepository.findById(id)!!
    }

    fun registerProduct(createProductDto: CreateProductDto) {
        productFactory.createProduct(createProductDto)
    }
}