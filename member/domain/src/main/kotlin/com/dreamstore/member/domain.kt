package com.dreamstore.member

enum class ROLE(val label:String){
    USER("일반유저"), ADMIN("관리자")
}

class Member(
    memberId:String,
    password:String,
    email:String,
    role:ROLE,
){
    val memberId:MemberId
    var password:String
    val email:Email
    val role:ROLE

    init {
        this.memberId=MemberId(memberId)
        this.password=password
        this.email= Email(email)
        this.role=role
    }

    fun encryptPassword(passwordEncoder : PasswordEncoderInterface){
        password = passwordEncoder.encode(this.password)
    }
}

class MemberId(
    val value:String
){
    init {
        if(value.isBlank()||value.length >15) throw IllegalArgumentException("아이디는 1~15자리 사이로 설정해주세요")
    }
}

class Email(
    var value: String
){
    init {
        val regex=Regex("^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$")
        if(!regex.matches(value)) throw IllegalArgumentException("이메일 형식이 맞지 않습니다")
    }
}