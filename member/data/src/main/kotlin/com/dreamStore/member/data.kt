package com.dreamStore.member

import com.dreamStore.base.CommonEntity
import com.dreamstore.member.Member
import javax.persistence.*

@Entity
@Table(name = "MEMBER")
class MemberData (
    @Column(name="MEMBER_ID")
    val memberId:String,
    @Column(name="PASSWORD")
    val password:String,
    @Column(name="EMAIL")
    val email:String="",
): CommonEntity(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long=0

    constructor(member: Member):this(member.memberId,member.password,
                                                    member.email)

    fun toEntity(): Member {
        return Member(id, memberId, password, email)
    }
}