package com.dreamStore.domain.member.data.adaptor.`in`

import com.dreamStore.domain.member.adaptor.out.MemberRepositoryAdaptor
import com.dreamStore.domain.member.data.MemberData
import com.dreamStore.domain.member.data.MemberJPARepository
import com.dreamStore.domain.member.dto.CreateMemberDto
import com.dreamStore.domain.member.dto.MemberDTO
import org.springframework.stereotype.Component

@Component
class MemberRepository(
    private val memberJPARepository: MemberJPARepository
): MemberRepositoryAdaptor {
    override fun findAll(): List<MemberDTO> {
        return memberJPARepository.findAll().map { it.toDTO() }
    }

    override fun findById(id: Long): MemberDTO? {
        return memberJPARepository.findById(id).get().toDTO()
    }

    override fun save(createMemberDto: CreateMemberDto) {
        memberJPARepository.save(MemberData(createMemberDto))
    }

}