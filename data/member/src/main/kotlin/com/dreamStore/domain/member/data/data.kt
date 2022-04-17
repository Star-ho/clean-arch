package com.dreamStore.domain.member.data

import com.dreamStore.base.CommonEntity
import com.dreamStore.domain.product.dto.CreateMemberDto
import com.dreamStore.domain.product.dto.MemberDTO
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

    constructor(createMemberDto: CreateMemberDto):this(createMemberDto.memberId,createMemberDto.password,
                                                    createMemberDto.email)

    fun toDTO():MemberDTO{
        return MemberDTO(id, memberId, password, email)
    }
}