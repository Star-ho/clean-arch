package com.dreamStore.member

import com.dreamStore.member.adaptor.out.MemberRepositoryAdaptor
import com.dreamstore.member.Member
import org.springframework.stereotype.Component

@Component
class MemberService(
    private val memberRepository: MemberRepositoryAdaptor,
) {

    fun getMemberList(): List<Member> {
        return memberRepository.findAll()
    }

    fun getMember(memberId : String): Member {
        return memberRepository.findById(memberId)?:throw IllegalArgumentException("해당 멤버가 없습니다")
    }

    fun registerMember(member: Member){
        memberRepository.save(member)
    }
}