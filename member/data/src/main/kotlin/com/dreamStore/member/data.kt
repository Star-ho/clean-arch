package com.dreamStore.member

import com.dreamStore.base.CommonEntity
import com.dreamstore.member.Member
import com.dreamstore.member.ROLE
import javax.persistence.*

@Entity
@Table(name = "MEMBER")
class MemberData (
    @Id
    val memberId:String,
    @Column(name="PASSWORD")
    val password:String,
    @Column(name="EMAIL")
    val email:String="",
    @Column(name="ROLE")
    val role:ROLE,
): CommonEntity(){

    constructor(member: Member):this(member.memberId.value,member.password,
                                                    member.email.value,member.role)

    fun toEntity(): Member {
        return Member(memberId, password, email,role)
    }
}