package com.dreamstore.member

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals


class MemberTest{

    @Test
    fun createMemberTest(){
        val id = 1L
        val memberId = "name"
        val password = "pass"
        val email = "tjdgh1231@dream.com"
        val member = Member(id,memberId,password,email)

        assertEquals(id,member.id)
        assertEquals(memberId,member.memberId)
        assertEquals(password,member.password)
        assertEquals(email,member.email)
    }

}