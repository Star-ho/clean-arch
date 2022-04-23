package com.dreamStore.order.adapter.`in`

import com.dreamStore.order.Order
import com.dreamStore.order.OrderJPARepository
import com.dreamStore.order.adaptor.out.OrderRepositoryAdaptor
import com.dreamstore.common.Price
import org.springframework.stereotype.Component

@Component
class OrderRepository(
    private val orderJpaRepository: OrderJPARepository
): OrderRepositoryAdaptor {
    override fun findAll(): List<Order> {
        return orderJpaRepository.findAll().map { Order(it.id, Price(it.price),it.member.toEntity(),
            it.orderEntryList.map { e -> e.toEntity() }) }
    }
}