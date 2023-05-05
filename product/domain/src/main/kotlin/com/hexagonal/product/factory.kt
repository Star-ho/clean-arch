package com.hexagonal.product

import com.hexagonal.common.Label
import com.hexagonal.common.Price
import com.hexagonal.product.adaptor.out.ProductRepository
import com.hexagonal.product.dto.CreateProductDto

class ProductFactory(
    private val productRepository: ProductRepository
) {

    fun createProduct(createProductDto: CreateProductDto) {
        val product = Product(0, Label(createProductDto.label), Price(createProductDto.price))
        productRepository.save(product)
    }
}