package com.dreamStore.domain.product.data

import com.dreamStore.base.CommonEntity
import com.dreamStore.domain.product.dto.CreateProductDto
import com.dreamStore.domain.product.dto.ProductDTO
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "PRODUCT")
class ProductData (
    @Column(name="LABEL")
    val label:String="",
    @Column(name="PRICE")
    val price:BigDecimal= BigDecimal.ZERO
): CommonEntity(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long=0

    constructor(createProductDto: CreateProductDto):this(createProductDto.label,createProductDto.price)

    fun toDTO():ProductDTO{
        return ProductDTO(id, label, price)
    }
}