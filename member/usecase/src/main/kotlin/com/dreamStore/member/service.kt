package com.dreamStore.member

import com.dreamStore.member.adaptor.out.MemberRepositoryAdaptor
import com.dreamStore.member.dto.CreateMemberDto
import com.dreamStore.member.dto.LoginDto
import com.dreamstore.member.Member
import com.dreamstore.member.ROLE
import org.springframework.dao.DuplicateKeyException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import javax.naming.AuthenticationException

@Component
class MemberService(
    private val memberRepository: MemberRepositoryAdaptor,
    private val passwordEncoder:PasswordEncoderImpl,
){

   @Throws(DuplicateKeyException::class)
    fun registerMember(createMemberDto: CreateMemberDto){
        val exist = memberRepository.existsById(createMemberDto.memberId)
        if (exist) throw DuplicateKeyException("해당되는 아이디가 있습니다.")
        val member=Member(memberId =  createMemberDto.memberId,password = createMemberDto.password,email =  createMemberDto.email,role = ROLE.USER)
        member.encryptPassword(passwordEncoder)
        memberRepository.save(member)
    }

    fun getMemberList(): List<Member> {
        return memberRepository.findAll()
    }

    fun getMember(memberId : String): Member {
        return memberRepository.findById(memberId)?:throw IllegalArgumentException("해당 멤버가 없습니다")
    }

}