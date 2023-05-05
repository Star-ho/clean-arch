package com.hexagonal.order

import com.hexagonal.common.Label
import com.hexagonal.common.Price
import com.hexagonal.product.Product
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProductTest {

    @Test
    fun createProductTest() {
        val id = 0L
        val label = "productLabel"
        val price = 1000
        val product = Product(id, Label(label), Price(price))

        assertEquals(id, product.id)
        assertEquals(label, product.label)
        assertEquals(price, product.price)

    }

    @Test
    fun createNoIdProductTest() {
        val label = "productLabel"
        val price = 1000
        val product = Product(label = Label(label), price = Price(price))

        assertEquals(label, product.label)
        assertEquals(price, product.price)

    }
}