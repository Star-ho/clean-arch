package com.dreamStore.order

import com.dreamStore.base.CommonEntity
import com.dreamStore.member.MemberData
import com.dreamStore.product.ProductData
import com.dreamstore.common.Price
import javax.persistence.*

@Entity
@Table(name = "Order")
class OrderData (
    @Column(name="Member")
    val label:String="",
    @Column(name="PRICE")
    val price: Int,
    @ManyToOne
    val member: MemberData,
    @OneToMany
    val orderEntryList:List<OrderEntryData> = mutableListOf()
): CommonEntity(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long=0
}

@Entity
@Table(name = "OrderEntry")
class OrderEntryData (
    @ManyToOne
    val product: ProductData,
    @ManyToOne
    val order: OrderData,
    @Column(name="PRICE")
    val price: Int,
): CommonEntity(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long=0

    fun toEntity(): OrderEntry {
        return OrderEntry(price = Price(price),product = product.toEntity())
    }
}