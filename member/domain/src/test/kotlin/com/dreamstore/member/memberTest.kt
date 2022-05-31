package com.dreamstore.member

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test


class MemberTest{

    @Test
    fun createMemberTest(){
        val memberId = "name"
        val password = "pass"
        val email = "tjdgh1231@dream.com"
        val role = ROLE.USER
        val member = Member(memberId,password,email,role)

        memberId shouldBe  member.memberId.value
        password shouldBe member.password
        email shouldBe member.email.value
    }


}