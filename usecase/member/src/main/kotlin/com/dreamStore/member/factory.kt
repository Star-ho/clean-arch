package com.dreamStore.member

import com.dreamStore.member.adaptor.out.MemberRepositoryAdaptor
import com.dreamstore.member.Member
import org.springframework.stereotype.Component

@Component
class MemberFactory(
    private val memberRepository: MemberRepositoryAdaptor
) {
    fun getProduct(id:Long): Member? {
        return memberRepository.findById(id)
    }

    fun registerProduct(member: Member){
        memberRepository.save(member)
    }
}