package com.hexagonal.member.adaptor.`in`

import com.hexagonal.member.Member
import com.hexagonal.member.MemberData
import com.hexagonal.member.MemberJPARepository
import com.hexagonal.member.adaptor.out.MemberRepository
import org.springframework.stereotype.Component

@Component
class MemberRepositoryImpl(
    private val memberJPARepository: MemberJPARepository
) : MemberRepository {
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