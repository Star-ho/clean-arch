package com.hexagonal.product

import com.dreamstore.common.Label
import com.dreamstore.common.Price
import com.hexagonal.base.CommonEntity
import javax.persistence.*

@Entity
@Table(name = "PRODUCT")
class ProductData(
    @Column(name = "LABEL")
    val label: String,
    @Column(name = "PRICE")
    val price: Int,
) : CommonEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    constructor(product: Product) : this(product.label.value, product.price.value)

    fun toEntity(): Product {
        return Product(id = id, label = Label(label), price = Price(price))
    }
}