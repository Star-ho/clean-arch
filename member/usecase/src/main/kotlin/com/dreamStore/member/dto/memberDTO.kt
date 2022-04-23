package com.dreamStore.member.dto

class CreateMemberDto(
    val memberId:String,
    val password: String,
    val email:String,
)

class MemberDTO( val id:Long=0,
                 val memberId: String,
                 val password: String,
                 val email: String){
}
