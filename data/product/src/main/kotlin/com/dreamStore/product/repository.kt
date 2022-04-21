package com.dreamStore.product

import com.dreamStore.domain.product.adaptor.out.ProductRepositoryAdaptor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductJPARepository : JpaRepository<ProductData, Long>