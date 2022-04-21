package com.dreamStore.product

import com.dreamStore.base.CommonEntity
import com.dreamStore.domain.product.dto.CreateProductDto
import com.dreamStore.domain.product.dto.ProductDTO
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "PRODUCT")
class ProductData (
    @Column(name="LABEL")
    val label:String,
    @Column(name="PRICE")
    val price:Int,
): CommonEntity(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long=0

    constructor(product: Product):this(product.label.label, product.price.price)

    fun toDTO():ProductDTO{
        return ProductDTO(id, label, price)
    }
}