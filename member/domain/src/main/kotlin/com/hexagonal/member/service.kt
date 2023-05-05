package com.hexagonal.member

import com.hexagonal.member.adaptor.out.MemberRepository
import com.hexagonal.member.dto.CreateMemberDto

class MemberService(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder,
) {

    fun registerMember(createMemberDto: CreateMemberDto) {
        val exist = memberRepository.existsById(createMemberDto.memberId)
        if (exist) throw IllegalArgumentException("해당되는 아이디가 있습니다.")
        val member = Member(
            memberId = createMemberDto.memberId,
            password = createMemberDto.password,
            email = createMemberDto.email,
            role = ROLE.USER
        )
        member.encryptPassword(passwordEncoder)
        memberRepository.save(member)
    }

    fun getMemberList(): List<Member> {
        return memberRepository.findAll()
    }

    fun getMember(memberId: String): Member {
        return memberRepository.findById(memberId) ?: throw IllegalArgumentException("해당 멤버가 없습니다")
    }

}