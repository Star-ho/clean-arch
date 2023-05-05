package com.hexagonal.member.adaptor.out

import com.hexagonal.member.Member


interface MemberRepository {
    fun findAll(): List<Member>
    fun findById(id: String): Member?
    fun save(member: Member)
    fun existsById(memberId: String): Boolean
}