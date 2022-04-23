package com.dreamStore.product.adaptor.`in`

import com.dreamStore.product.Product
import com.dreamStore.product.ProductData
import com.dreamStore.product.ProductJPARepository
import com.dreamStore.product.adaptor.out.ProductRepositoryAdaptor
import org.springframework.stereotype.Component

@Component
class ProductRepository(
    private val productJPARepository: ProductJPARepository,
): ProductRepositoryAdaptor {
    override fun findAll(): List<Product> {
        return productJPARepository.findAll().map { it.toEntity() }
    }

    override fun findById(id: Long): Product? {
        return productJPARepository.findById(id).get().toEntity()
    }

    override fun save(product: Product) {
        productJPARepository.save(ProductData(product))
    }
}