package com.dreamStore.member

import com.dreamStore.base.CommonEntity
import com.dreamStore.domain.member.dto.CreateMemberDto
import com.dreamStore.domain.member.dto.MemberDTO
import javax.persistence.*

@Entity
@Table(name = "MEMEBER")
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

    fun toDTO(): MemberDTO {
        return MemberDTO(id, memberId, password, email)
    }
}