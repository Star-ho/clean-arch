package com.dreamStore.member.request

import com.dreamStore.domain.member.dto.CreateMemberDto

class RegisterMemberRequest(
    val memberId:String,
    val password:String,
    val email:String,
){
    fun toDto()= CreateMemberDto(memberId, password, email)
}