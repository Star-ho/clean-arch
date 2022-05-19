package com.dreamStore.order

import com.dreamStore.member.MemberService
import com.dreamStore.order.adaptor.out.OrderRepositoryAdaptor
import com.dreamStore.order.dto.RegisterOrderDTO
import com.dreamStore.product.ProductService
import com.dreamstore.common.Price
import org.springframework.stereotype.Component

@Component
class OrderService(
    private val orderRepository: OrderRepositoryAdaptor,
    private val productService: ProductService,
    private val memberService: MemberService,
){
    fun getOrders(): List<Order> {
        return orderRepository.findAll()
    }

    fun registerOrder(registerOrderDTO: RegisterOrderDTO){
        val orderEntryList = registerOrderDTO.products.map {
            val product = productService.getProduct(it.productId)
            OrderEntry(product = product,price = product.price,quantity = Quantity(it.quantity))
        }
        val totalPrice = Price(0)
        orderEntryList.forEach { totalPrice.plus(it.price) }
        val order = Order( totalPrice = totalPrice,
        member = memberService.getMember(registerOrderDTO.memberId),orderEntryList = orderEntryList)
        orderRepository.save(order)
    }
}