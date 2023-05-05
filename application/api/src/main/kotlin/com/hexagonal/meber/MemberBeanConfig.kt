package com.hexagonal.meber

import com.hexagonal.member.MemberService
import com.hexagonal.member.PasswordEncoder
import com.hexagonal.member.adaptor.out.MemberRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MemberBeanConfig(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder,
) {
    @Bean
    fun memberService(): MemberService {
        return MemberService(memberRepository, passwordEncoder)
    }
}