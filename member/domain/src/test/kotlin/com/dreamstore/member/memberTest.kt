package com.dreamstore.member

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals


class MemberTest{

    @Test
    fun createMemberTest(){
        val memberId = "name"
        val password = "pass"
        val email = "tjdgh1231@dream.com"
        val member = Member(memberId,password,email)

        assertEquals(memberId,member.memberId)
        assertEquals(password,member.password)
        assertEquals(email,member.email)
    }

}