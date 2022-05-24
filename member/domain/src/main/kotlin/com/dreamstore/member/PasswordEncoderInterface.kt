package com.dreamstore.member

interface PasswordEncoderInterface {
    fun encode(password:String): String
}