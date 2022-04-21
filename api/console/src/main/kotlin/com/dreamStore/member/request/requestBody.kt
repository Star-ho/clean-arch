package com.dreamStore.member.request

import com.dreamStore.member.dto.CreateMemberDto
import com.dreamstore.member.Member

class RegisterMemberRequest(
    val memberId:String,
    val password:String,
    val email:String,
){
    fun toEntity() = Member(memberId, password, email)
}