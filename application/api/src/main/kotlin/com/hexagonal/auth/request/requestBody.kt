package com.hexagonal.auth.request

import com.hexagonal.member.Member
import com.hexagonal.member.ROLE


class MemberRegisterRequest(
    val memberId: String,
    val password: String,
    val email: String,
    val role: ROLE,
) {
    fun toEntity() = Member(memberId, password, email, role)
}