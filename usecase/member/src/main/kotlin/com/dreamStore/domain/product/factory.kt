package com.dreamStore.domain.product

import com.dreamStore.domain.product.adaptor.out.MemberRepositoryAdaptor
import com.dreamStore.domain.product.dto.CreateMemberDto
import com.dreamStore.domain.product.dto.MemberDTO
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