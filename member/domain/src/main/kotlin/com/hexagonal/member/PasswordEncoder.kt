package com.hexagonal.member

interface PasswordEncoder {
    fun encode(password: String): String
}