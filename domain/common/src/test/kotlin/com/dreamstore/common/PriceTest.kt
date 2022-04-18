package com.dreamstore.common

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Test

class PriceTest{

    @Test
    fun priceCorrectTest(){
        assertThrows<IllegalArgumentException> { Price(-1) }
    }

    @Test
    fun minusPriceTest(){
        assertThrows<IllegalArgumentException> { Price(-1) }
    }
}