package com.dreamStore.domain.product.data

import com.dreamStore.base.CommonEntity
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
}