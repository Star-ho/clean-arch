package com.dreamStore.order.dto

class RegisterOrderDTO(
    val memberId:String,
    val products:List<ProductAmountDTO>,
)

class ProductAmountDTO(
    val productId:Long,
    val quantity:Int
)