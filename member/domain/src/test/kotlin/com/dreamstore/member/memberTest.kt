package com.dreamstore.member

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException


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

    @Test
    fun email(){
        var email = "tjdgh1231ream.com"
        shouldThrow<IllegalArgumentException> {
            Email(email)
        }
        email = "tjdgh1231@reamcom"
        shouldThrow<IllegalArgumentException> {
            Email(email)
        }
        email = "tjdgh1231@ream.com"
        shouldNotThrow<IllegalArgumentException> {
            Email(email)
        }
    }
}