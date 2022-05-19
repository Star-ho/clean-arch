package com.dreamStore.member.request

import com.dreamstore.member.Member

class MemberRegisterRequest(
    val memberId:String,
    val password:String,
    val email:String,
){
    fun toEntity() = Member(memberId, password, email)
}