package com.hexagonal.common

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LabelTest {

    @Test
    fun labelMinLengthTest() {
        assertThrows<IllegalArgumentException> { Label("") }
    }

    @Test
    fun labelMaxLengthTest() {
        assertThrows<IllegalArgumentException> { Label("123456789012345678901") }
    }

    @Test
    fun labelCorrectTest() {
        Label("1234567890123456789")
    }
}