package com.dreamStore.product

import com.dreamStore.product.adaptor.out.ProductRepositoryAdaptor
import com.dreamStore.product.dto.CreateProductDto
import org.springframework.stereotype.Component

@Component
class ProductService(
    private val productFactory: ProductFactory,
    private val productRepositoryAdaptor: ProductRepositoryAdaptor,
) {
    fun getProductList(): List<Product> {
        return productRepositoryAdaptor.findAll()

    fun getProduct(id:Long): Product {
        return productRepository.findById(id)!!
    }
    fun registerProduct(createProductDto: CreateProductDto){
        productFactory.registerProduct(createProductDto.toEntity())
    }
}