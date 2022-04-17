package com.dreamStore.domain.member

import com.dreamStore.domain.member.adaptor.out.MemberRepositoryAdaptor
import com.dreamStore.domain.member.dto.CreateMemberDto
import com.dreamStore.domain.member.dto.MemberDTO
import org.springframework.stereotype.Component

@Component
class MemberService(
    private val memberFactory: MemberFactory,
    private val memberRepositoryAdaptor: MemberRepositoryAdaptor,
) {
    fun getProductList(): List<MemberDTO> {
        return memberRepositoryAdaptor.findAll()

    }
    fun registerProduct(createProductDto: CreateMemberDto){
        memberFactory.registerProduct(createProductDto)
    }
}