package com.dreamStore.product

import com.dreamstore.common.Label
import com.dreamstore.common.Price
import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@ExtendWith(MockitoExtension::class)
@WebMvcTest(ProductController::class)
internal class ProductControllerTest {
    @MockkBean
    lateinit var productService: ProductService

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun getProductList() {
        val products = listOf(
            Product(id = 1, label = Label("testLabel1"), price= Price(1000)),
            Product(id = 2, label = Label("testLabel2"), price= Price(2000))
        )
        every { productService.getProductList() } returns products

        mockMvc.perform(
            MockMvcRequestBuilders.get("/product")
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(jsonPath("\$.[0].id").value("1"))
            .andExpect(jsonPath("\$.[0].label").value("testLabel1"))
            .andExpect(jsonPath("\$.[0].price").value("1000"))
            .andExpect(jsonPath("\$.[1].id").value("2"))
            .andExpect(jsonPath("\$.[1].label").value("testLabel2"))
            .andExpect(jsonPath("\$.[1].price").value("2000"))
    }

    @Test
    fun registerProduct() {
        throw IllegalArgumentException("fff")
    }
}