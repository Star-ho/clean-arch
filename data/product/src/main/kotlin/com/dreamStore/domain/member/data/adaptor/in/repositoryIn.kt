package com.dreamStore.domain.member.data.adaptor.`in`

import com.dreamStore.domain.product.adaptor.out.ProductRepositoryAdaptor
import com.dreamStore.domain.member.data.ProductData
import com.dreamStore.domain.member.data.ProductJPARepository
import com.dreamStore.domain.product.dto.CreateProductDto
import com.dreamStore.domain.product.dto.ProductDTO
import org.springframework.stereotype.Component

@Component
class ProductRepository(
    private val productJPARepository: ProductJPARepository
):ProductRepositoryAdaptor{
    override fun findAll(): List<ProductDTO> {
        return productJPARepository.findAll().map { it.toDTO() }
    }

    override fun findById(id: Long): ProductDTO? {
        return productJPARepository.findById(id).get().toDTO()
    }

    override fun save(createProductDto: CreateProductDto) {
        productJPARepository.save(ProductData(createProductDto))
    }

}