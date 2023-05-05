package com.hexagonal.order

import com.hexagonal.common.Price
import com.hexagonal.member.adaptor.out.MemberRepository
import com.hexagonal.order.adaptor.out.OrderRepository
import com.hexagonal.order.dto.CreateOrderEntryRequest
import com.hexagonal.order.dto.RegisterOrderRequest
import com.hexagonal.product.adaptor.out.ProductRepository

class OrderFactory(
    private val productRepository: ProductRepository,
    private val memberRepository: MemberRepository,
    private val orderRepository: OrderRepository,
) {
    fun createOrder(registerOrderRequest: RegisterOrderRequest) {
        val orderEntryList = registerOrderRequest.products.map { createOrderEntry(it) }
        val totalPrice = Price(0)
        orderEntryList.forEach { totalPrice.plus(it.price) }

        val member =
            memberRepository.findById(registerOrderRequest.memberId) ?: throw IllegalArgumentException("멤버를 찾을 수 없습니다")
        val order = Order(
            totalPrice = totalPrice,
            member = member, orderEntryList = orderEntryList
        )
        orderRepository.save(order)
    }

    private fun createOrderEntry(createOrderEntryRequest: CreateOrderEntryRequest): OrderEntry {
        val product = productRepository.findById(createOrderEntryRequest.productId)
            ?: throw IllegalArgumentException("상품이 존재하지 않습니다")
        return OrderEntry(
            product = product,
            price = product.price,
            quantity = Quantity(createOrderEntryRequest.quantity)
        )
    }
}