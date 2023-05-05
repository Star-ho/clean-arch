package com.dreamStore.config

import com.dreamStore.member.MemberService
import com.dreamStore.member.PasswordEncoderImpl
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component
import javax.naming.AuthenticationException

@Component
class CustomAuthenticationManager(
    private val memberService: MemberService,
    private val passwordEncoder: PasswordEncoderImpl,
) : AuthenticationManager {
    override fun authenticate(authentication: Authentication?): Authentication {
        val member = memberService.getMember(authentication!!.principal.toString())
        if (passwordEncoder.match(authentication.credentials.toString(), member.password)) {
            val role = listOf(SimpleGrantedAuthority(member.role.name))
            return UsernamePasswordAuthenticationToken(member.memberId, member.password, role)
        }
        throw AuthenticationException("패스워드가 다릅니다.")
    }
}