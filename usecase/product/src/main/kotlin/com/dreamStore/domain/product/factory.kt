package com.dreamStore.domain.product

import com.dreamStore.domain.product.data.ProductData
import com.dreamStore.domain.product.data.ProductRepository
import com.dreamStore.domain.product.dto.CreateProductDto
import com.dreamStore.domain.product.dto.ProductDTO
import org.springframework.stereotype.Component

@Component
class ProductFactory(
    private val productRepository: ProductRepository
) {
    fun getProduct(id:Long){
        val productData=productRepository.findById(id).get()
//        return ProductDTO(productData.label,productData.price)
    }

    fun registerProduct(productDto: CreateProductDto): ProductDTO {
        val product = ProductData(productDto.label,productDto.price)
        val saved = productRepository.save(product)
        return ProductDTO(saved)
    }
}