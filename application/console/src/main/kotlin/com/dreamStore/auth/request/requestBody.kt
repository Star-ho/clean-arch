package com.dreamStore.auth.request

import com.dreamstore.member.Member
import com.dreamstore.member.ROLE

class MemberRegisterRequest(
    val memberId:String,
    val password:String,
    val email:String,
    val role:ROLE,
){
    fun toEntity() = Member(memberId, password, email,role)
}