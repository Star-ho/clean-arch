package com.dreamStore.member

import com.dreamstore.member.PasswordEncoderInterface
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordEncoderImpl(
    private val passwordEncoder: BCryptPasswordEncoder
):PasswordEncoderInterface {
    override fun encode(password:String): String {
        return  passwordEncoder.encode(password)
    }
    fun match(password: String,encodedPassword:String):Boolean{
        return passwordEncoder.matches(password,encodedPassword)
    }
}