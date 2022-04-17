package com.dreamStore.domain.member.adaptor.out

import com.dreamStore.domain.member.dto.CreateMemberDto
import com.dreamStore.domain.member.dto.MemberDTO

interface MemberRepositoryAdaptor{
    fun findAll():List<MemberDTO>
    fun findById(id:Long): MemberDTO?
    fun save(createProductDto: CreateMemberDto)
}