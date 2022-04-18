package com.dreamStore.domain

import com.dreamStore.domain.product.Product
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.math.BigDecimal

class ProductTest{

    @Test
    fun createProductTest(){
        val id = 0L
        val label = "productLabel"
        val price = BigDecimal(1000)
        val product = Product(id,label,price)

        assertEquals(id,product.id)
        assertEquals(label,product.label)
        assertEquals(price,product.price)

    }

    @Test
    fun createNoIdProductTest(){
        val label = "productLabel"
        val price = BigDecimal(1000)
        val product = Product(label = label,price = price)

        assertEquals(label,product.label)
        assertEquals(price,product.price)

    }
}