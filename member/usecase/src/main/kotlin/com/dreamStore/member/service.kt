package com.dreamStore.member

import com.dreamStore.member.adaptor.out.MemberRepositoryAdaptor
import com.dreamstore.member.Member
import org.springframework.stereotype.Component

@Component
class MemberService(
    private val memberFactory: MemberFactory,
    private val memberRepositoryAdaptor: MemberRepositoryAdaptor,
) {

    fun getProductList(): List<Member> {
        return memberRepositoryAdaptor.findAll()
    }

    fun registerProduct(member: Member){
        memberFactory.registerProduct(member)
    }
}