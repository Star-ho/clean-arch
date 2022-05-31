package com.dreamstore.member

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class EmailTest {
    @Test
    fun emailValid(){
        var email = "tjdgh1231ream.com"
        shouldThrow<IllegalArgumentException> {
            Email(email)
        }
        email = "tjdgh1231@reamcom"
        shouldThrow<IllegalArgumentException> {
            Email(email)
        }
        email = "@ream.com"
        shouldThrow<IllegalArgumentException> {
            Email(email)
        }
        email = "tjdgh1231@"
        shouldThrow<IllegalArgumentException> {
            Email(email)
        }
        email = "tjdgh1231@ream.com"
        shouldNotThrow<IllegalArgumentException> {
            Email(email)
        }
    }
}