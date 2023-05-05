package com.hexagonal.product

import com.hexagonal.product.adaptor.out.ProductRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProductBeanConfig(
    private val productRepository: ProductRepository
) {
    @Bean
    fun productService(): ProductService {
        return ProductService(productFactory(), productRepository)
    }

    @Bean
    fun productFactory(): ProductFactory {
        return ProductFactory(productRepository)
    }
}