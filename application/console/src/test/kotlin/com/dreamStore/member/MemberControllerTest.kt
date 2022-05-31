package com.dreamStore.member

import com.dreamStore.auth.AuthController
import com.dreamStore.member.dto.CreateMemberDto
import com.dreamstore.member.Member
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.doNothing
import org.mockito.Mockito
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
class MemberControllerTest{

    @MockBean
    lateinit var memberService:MemberService

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun registerMemberTest(){
        doNothing().`when`(memberService).registerMember(any(CreateMemberDto::class.java))

        val valueMap = mutableMapOf<String,String>()
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