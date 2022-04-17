package com.dreamstore.member

import java.math.BigDecimal

class Member(
    val id:Long?=null,
    val memberId:String,
    val password:BigDecimal,
    val email:String,
)