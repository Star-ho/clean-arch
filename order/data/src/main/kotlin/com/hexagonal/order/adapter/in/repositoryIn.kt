package com.hexagonal.order.adapter.`in`

import com.hexagonal.member.MemberJPARepository
import com.hexagonal.order.*
import com.hexagonal.order.adaptor.out.OrderRepository
import com.hexagonal.product.ProductJPARepository
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryImpl(
    private val orderJpaRepository: OrderJPARepository,
    private val productJPARepository: ProductJPARepository,
    private val memberJPARepository: MemberJPARepository,
    private val orderEntryJPARepository: OrderEntryJPARepository
) : OrderRepository {
    override fun findAll(): List<Order> {
        return orderJpaRepository.findAll().map { it.toEntity() }
    }

    override fun findById(id: Long): Order {
        return orderJpaRepository.findById(id).get().toEntity()
    }

    override fun save(order: Order) {
        val orderEntryDataList = order.orderEntryList.map {
            orderEntryJPARepository.save(
                OrderEntryData(
                    product = productJPARepository.findById(it.product.id).get(),
                    price = it.price.value, quantity = it.quantity.value
                )
            )
        }

        val orderData = OrderData(
            member = memberJPARepository.findById(order.member.memberId.value).orElseThrow(),
            totalPrice = order.totalPrice.value
        )

        orderData.addOrderEntries(orderEntryDataList as MutableList<OrderEntryData>)
        orderJpaRepository.save(orderData)
    }
}