package com.dreamStore.domain.member

import com.dreamStore.domain.member.adaptor.out.MemberRepositoryAdaptor
import com.dreamStore.domain.member.dto.CreateMemberDto
import com.dreamStore.domain.member.dto.MemberDTO
import org.springframework.stereotype.Component

@Component
class MemberFactory(
    private val memberRepository: MemberRepositoryAdaptor
) {
    fun getProduct(id:Long): MemberDTO? {
        return memberRepository.findById(id)
    }

    fun registerProduct(createProductDto: CreateMemberDto){
        memberRepository.save(createProductDto)
    }
}