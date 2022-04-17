package com.dreamStore.domain.member.data

import com.dreamStore.domain.product.adaptor.out.ProductRepositoryAdaptor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductJPARepository : JpaRepository<ProductData, Long>