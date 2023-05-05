package com.hexagonal.common

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PriceTest {

    @Test
    fun priceCorrectTest() {
        assertThrows<IllegalArgumentException> { Price(-1) }
    }

    @Test
    fun minusPriceTest() {
        assertThrows<IllegalArgumentException> { Price(-1) }
    }
}