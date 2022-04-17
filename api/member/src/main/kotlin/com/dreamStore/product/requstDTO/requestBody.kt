package com.dreamStore.product.requstDTO

import com.dreamStore.domain.product.dto.CreateMemberDto

class RegisterMemberRequest(
    val memberId:String,
    val password:String,
    val email:String,
){
    fun toDto()=CreateMemberDto(memberId, password, email)
}