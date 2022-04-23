package com.dreamStore.product.adaptor.out

import com.dreamStore.product.Product

interface ProductRepositoryAdaptor{
    fun findAll():List<Product>
    fun findById(id:Long): Product?
    fun save(product: Product)
}