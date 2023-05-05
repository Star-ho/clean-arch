package com.hexagonal.order

import com.hexagonal.member.Member
import com.hexagonal.member.MemberService
import com.hexagonal.member.ROLE
import com.hexagonal.member.adaptor.out.MemberRepositoryAdaptor
import com.hexagonal.member.dto.CreateMemberDto
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class MemberServiceTest {

    @MockK
    lateinit var memberRepositoryAdaptor: MemberRepositoryAdaptor

    @InjectMockKs
    lateinit var memberService: MemberService

    @Test
    fun getMemberListTest() {
        val memberList: MutableList<Member> = mutableListOf(
            Member("id1", "password1", "email1", ROLE.USER),
            Member("id2", "password2", "email2", ROLE.ADMIN)
        )
        every { memberRepositoryAdaptor.findAll() } returns memberList

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
        val member = CreateMemberDto("memberId", "password", "email")

        every { memberRepositoryAdaptor.save(any()) } returns Unit

        memberService.registerMember(member)
    }
}
