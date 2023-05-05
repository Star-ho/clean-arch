package com.hexagonal.member

interface PasswordEncoderInterface {
    fun encode(password: String): String
}