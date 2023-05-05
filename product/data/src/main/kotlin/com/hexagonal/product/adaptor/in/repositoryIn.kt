package com.hexagonal.product.adaptor.`in`

import com.hexagonal.product.Product
import com.hexagonal.product.ProductData
import com.hexagonal.product.ProductJPARepository
import com.hexagonal.product.adaptor.out.ProductRepository
import org.springframework.stereotype.Component

@Component
class ProductRepositoryImpl(
    private val productJPARepository: ProductJPARepository,
) : ProductRepository {
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