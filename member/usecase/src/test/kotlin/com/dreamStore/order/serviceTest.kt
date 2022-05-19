package com.dreamStore.order

import io.mockk.every
import org.junit.jupiter.api.Test
import io.kotest.matchers.shouldBe
import com.dreamstore.member.Member
import io.mockk.junit5.MockKExtension
import io.mockk.impl.annotations.MockK
import com.dreamStore.member.MemberService
import io.mockk.impl.annotations.InjectMockKs
import org.junit.jupiter.api.extension.ExtendWith
import com.dreamStore.member.adaptor.out.MemberRepositoryAdaptor

@ExtendWith(MockKExtension::class)
class MemberServiceTest {

    @MockK
    lateinit var memberRepositoryAdaptor: MemberRepositoryAdaptor

    @InjectMockKs
    lateinit var memberService: MemberService

    @Test
    fun getMemberListTest(){
        val memberList:MutableList<Member> = mutableListOf(
            Member("id1","password1","email1"),
            Member("id2","password2","email2")
        )
        every { memberRepositoryAdaptor.findAll() } returns memberList

        val res = memberService.getMemberList()

        res.size shouldBe memberList.size

        for(i in memberList.indices){
            memberList[i].memberId shouldBe res[i].memberId
            memberList[i].password shouldBe res[i].password
            memberList[i].email shouldBe res[i].email
        }
    }

    @Test
    fun createMemberTest(){
        val member = Member("memberId","password", "email")

        every { memberRepositoryAdaptor.save(any()) } returns Unit

        memberService.registerMember(member)
    }
}
