package com.dreamstore.member

class Member(
    val id:Long?=null,
    val memberId:String,
    val password:String,
    val email:String,
){
    constructor(memberId: String,password: String,email: String):this(null,memberId,password,email)
}