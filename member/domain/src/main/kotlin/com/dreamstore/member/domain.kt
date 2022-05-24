package com.dreamstore.member

enum class ROLE(val label:String){
    USER("일반유저"), ADMIN("관리자")
}

class Member(
    val memberId:String,
    var password:String,
    val email:String,
    val role:ROLE,
){
    fun encryptPassword(passwordEncoder : PasswordEncoderInterface){
        password = passwordEncoder.encode(this.password)
    }
}
