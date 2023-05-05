package com.hexagonal.member

import com.hexagonal.base.CommonEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "MEMBER")
class MemberData(
    @Id
    val memberId: String,
    @Column(name = "PASSWORD")
    val password: String,
    @Column(name = "EMAIL")
    val email: String = "",
    @Column(name = "ROLE")
    val role: ROLE,
) : CommonEntity() {

    constructor(member: Member) : this(
        member.memberId.value, member.password,
        member.email.value, member.role
    )

    fun toEntity(): Member {
        return Member(memberId, password, email, role)
    }
}