package com.hexagonal.order

import com.hexagonal.member.adaptor.out.MemberRepository
import com.hexagonal.order.adaptor.out.OrderRepository
import com.hexagonal.product.adaptor.out.ProductRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OrderBeanConfig(
    private val orderRepository: OrderRepository,
    private val productRepository: ProductRepository,
    private val memberRepository: MemberRepository,
) {
    @Bean
    fun orderService(): OrderService {
        return OrderService(orderRepository, orderFactory())
    }

    @Bean
    fun orderFactory(): OrderFactory {
        return OrderFactory(productRepository, memberRepository, orderRepository)
    }
}