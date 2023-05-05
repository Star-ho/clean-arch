package com.hexagonal.member

import com.hexagonal.auth.AuthController
import com.fasterxml.jackson.databind.ObjectMapper
import com.hexagonal.member.dto.CreateMemberDto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.Mockito.doNothing
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean

import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(MockitoExtension::class)
@WebMvcTest(AuthController::class)
private class MemberControllerTest {

    @MockBean
    lateinit var memberService: MemberService

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun registerMemberTest() {
        doNothing().`when`(memberService).registerMember(any(CreateMemberDto::class.java))

        val valueMap = mutableMapOf<String, String>()
        valueMap["memberId"] = "testMemberId"
        valueMap["password"] = "testPassword"
        valueMap["email"] = "testEmail"

        mockMvc.perform(
            MockMvcRequestBuilders.post("/member").content(objectMapper.writeValueAsString(valueMap))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk)
    }

    private fun <T> any(type: Class<T>): T = Mockito.any(type)
}