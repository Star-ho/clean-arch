package com.hexagonal.member.adaptor.`in`

import com.dreamStore.member.adaptor.out.MemberRepositoryAdaptor
import com.dreamstore.member.Member
import com.hexagonal.member.MemberData
import com.hexagonal.member.MemberJPARepository
import org.springframework.stereotype.Component

@Component
class MemberRepository(
    private val memberJPARepository: MemberJPARepository
) : MemberRepositoryAdaptor {
    override fun findAll(): List<Member> {
        return memberJPARepository.findAll().map { it.toEntity() }
    }

    override fun findById(id: String): Member? {
        return memberJPARepository.findById(id).get().toEntity()
    }

    override fun save(member: Member) {
        memberJPARepository.save(MemberData(member))
    }

    override fun existsById(memberId: String): Boolean {
        return memberJPARepository.existsById(memberId)
    }

}