package com.dreamStore.member

import com.dreamStore.base.CommonEntity
import com.dreamstore.member.Member
import javax.persistence.*

@Entity
@Table(name = "MEMBER")
class MemberData (
    @Id
    val memberId:String = "",
    @Column(name="PASSWORD")
    val password:String = "",
    @Column(name="EMAIL")
    val email:String="",
): CommonEntity(){

    constructor(member: Member):this(member.memberId,member.password,
                                                    member.email)

    fun toEntity(): Member {
        return Member(memberId, password, email)
    }
}