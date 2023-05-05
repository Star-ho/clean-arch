package com.hexagonal.product.adaptor.out

import com.hexagonal.product.Product

interface ProductRepository {
    fun findAll(): List<Product>
    fun findById(id: Long): Product?
    fun save(product: Product)
}