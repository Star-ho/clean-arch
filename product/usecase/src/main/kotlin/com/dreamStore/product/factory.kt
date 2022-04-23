package com.dreamStore.product

import com.dreamStore.product.adaptor.out.ProductRepositoryAdaptor
import org.springframework.stereotype.Component

@Component
class ProductFactory(
    private val productRepository: ProductRepositoryAdaptor
) {
    fun getProduct(id:Long): Product? {
        return productRepository.findById(id)
    }

    fun registerProduct(product: Product){
        productRepository.save(product)
    }
}