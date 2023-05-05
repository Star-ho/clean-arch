package com.hexagonal.product

import com.dreamstore.common.Label
import com.dreamstore.common.Price
import com.hexagonal.product.adaptor.out.ProductRepository
import com.hexagonal.product.dto.CreateProductDto
import org.springframework.stereotype.Component

@Component
class ProductFactory(
    private val productRepository: ProductRepository
) {

    fun createProduct(createProductDto: CreateProductDto) {
        val product = Product(0, Label(createProductDto.label), Price(createProductDto.price))
        productRepository.save(product)
    }
}