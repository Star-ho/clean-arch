package com.dreamStore.order.adapter.`in`

import com.dreamStore.member.MemberJPARepository
import com.dreamStore.order.*
import com.dreamStore.order.adaptor.out.OrderRepositoryAdaptor
import com.dreamStore.product.ProductJPARepository
import com.dreamstore.common.Price
import org.springframework.stereotype.Component

@Component
class OrderRepository(
    private val orderJpaRepository: OrderJPARepository,
    private val productJPARepository: ProductJPARepository,
    private val memberJPARepository: MemberJPARepository,
    private val orderEntryJPARepository: OrderEntryJPARepository
): OrderRepositoryAdaptor {
    override fun findAll(): List<Order> {
        return orderJpaRepository.findAll().map { Order(it.id, Price(it.totalPrice),it.member.toEntity(),
            it.orderEntryList.map { e -> e.toEntity() }) }
    }

    override fun save(order: Order) {
        val orderEntryDataList = order.orderEntryList.map{
            orderEntryJPARepository.save(OrderEntryData( product = productJPARepository.findById(it.product.id).get(),
            price = it.price.value, quantity = it.quantity.value)) }

        val orderData = OrderData(member = memberJPARepository.findById(order.member.memberId).orElseThrow(),
            totalPrice = order.totalPrice.value)

        orderData.addOrderEntries(orderEntryDataList as MutableList<OrderEntryData>)
        orderJpaRepository.save(orderData)

    }
}