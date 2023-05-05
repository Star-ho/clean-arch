package com.hexagonal.order

import com.hexagonal.member.MemberId
import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class MemberIdTest {

    @Test
    fun memberIdValidTest() {
        var memberId = ""
        shouldThrow<IllegalArgumentException> {
            MemberId(memberId)
        }

        memberId = "abcdefghijklmnopqrstu"
        shouldThrow<IllegalArgumentException> {
            MemberId(memberId)
        }

        memberId = "id"
        MemberId(memberId)
    }
}