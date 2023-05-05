package com.hexagonal.order

import com.dreamStore.member.MemberService
import com.dreamStore.product.ProductService
import com.hexagonal.order.adaptor.out.OrderRepositoryAdaptor
import com.hexagonal.order.dto.RegisterOrderDTO
import org.springframework.stereotype.Component

@Component
class OrderService(
    private val orderRepository: OrderRepositoryAdaptor,
    private val productService: ProductService,
    private val memberService: MemberService,
) {
    fun getOrders(): List<Order> {
        return orderRepository.findAll()
    }

    fun getOrder(id: Long): Order {
        return orderRepository.findById(id)
    }

    fun registerOrder(registerOrderDTO: RegisterOrderDTO) {

    }
}