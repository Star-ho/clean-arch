package com.hexagonal.order

import com.hexagonal.member.Member
import com.hexagonal.member.MemberService
import com.hexagonal.member.PasswordEncoder
import com.hexagonal.member.ROLE
import com.hexagonal.member.adaptor.out.MemberRepository
import com.hexagonal.member.dto.CreateMemberDto
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class MemberServiceTest {

    private val memberRepository: MemberRepository = mockk()
    private val passwordEncoderImpl: PasswordEncoder = mockk()
    private val memberService = MemberService(memberRepository, passwordEncoderImpl)

    @Test
    fun getMemberListTest() {
        val memberList: MutableList<Member> = mutableListOf(
            Member("id1", "password1", "email1@sungho.com", ROLE.USER),
            Member("id2", "password2", "email2@sungho.com", ROLE.ADMIN)
        )
        every { memberRepository.findAll() } returns memberList

        val res = memberService.getMemberList()

        res.size shouldBe memberList.size

        for (i in memberList.indices) {
            memberList[i].memberId shouldBe res[i].memberId
            memberList[i].password shouldBe res[i].password
            memberList[i].email shouldBe res[i].email
        }
    }

    @Test
    fun createMemberTest() {
        val member = CreateMemberDto("memberId", "password", "email@ccc.com")

        // 분리하기
        every { memberRepository.save(any()) } returns Unit
        every { memberRepository.existsById(any()) } returns false
        every { passwordEncoderImpl.encode(any()) } returns "asdf"

        memberService.registerMember(member)
    }
}
