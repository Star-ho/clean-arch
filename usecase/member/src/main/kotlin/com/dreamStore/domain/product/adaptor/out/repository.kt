package com.dreamStore.domain.product.adaptor.out

import com.dreamStore.domain.product.dto.CreateMemberDto
import com.dreamStore.domain.product.dto.MemberDTO

interface MemberRepositoryAdaptor{
    fun findAll():List<MemberDTO>
    fun findById(id:Long):MemberDTO?
    fun save(createProductDto: CreateMemberDto)
}