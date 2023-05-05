package com.hexagonal.order

import com.dreamStore.member.adaptor.out.MemberRepositoryAdaptor
import com.dreamStore.product.adaptor.out.ProductRepository
import com.dreamstore.common.Price
import com.hexagonal.order.adaptor.out.OrderRepositoryAdaptor
import com.hexagonal.order.dto.CreateOrderEntryRequest
import com.hexagonal.order.dto.RegisterOrderDTO

class OrderFactory(
    private val productRepository: ProductRepository,
    private val memberRepository: MemberRepositoryAdaptor,
    private val orderRepositoryAdaptor: OrderRepositoryAdaptor,
    private val orderEntryReq
) {
    fun createOrder(registerOrderDTO: RegisterOrderDTO) {
        val orderEntryList = registerOrderDTO.products.map { createOrderEntry(it) }
        val totalPrice = Price(0)
        orderEntryList.forEach { totalPrice.plus(it.price) }

        val member =
            memberRepository.findById(registerOrderDTO.memberId) ?: throw IllegalArgumentException("멤버를 찾을 수 없습니다")
        val order = Order(
            totalPrice = totalPrice,
            member = member, orderEntryList = orderEntryList
        )
        orderRepositoryAdaptor.save(order)
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