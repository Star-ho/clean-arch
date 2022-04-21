import com.dreamStore.order.Order
import com.dreamStore.order.adaptor.out.OrderRepositoryAdaptor
import org.springframework.stereotype.Component

@Component
class OrderService(
    private val orderRepository: OrderRepositoryAdaptor,
){
    fun getOrders(): List<Order> {
        return orderRepository.findAll()
    }

}