package com.dreamStore.member

import com.dreamstore.member.Member
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDateTime
import java.time.ZonedDateTime

class CustomUserDetail(
    member: Member
):UserDetails {
    private val userName:String
    private val password:String
    private val authorities:MutableCollection<out GrantedAuthority>
    private val loginDateTime:LocalDateTime
    init {
        userName=member.memberId.value
        password=member.password
        authorities= mutableListOf(SimpleGrantedAuthority(member.role.name))
        loginDateTime=ZonedDateTime.now().toLocalDateTime()
    }

    override fun getUsername(): String {
        return this.username
    }

    override fun getPassword(): String {
        return this.password
    }


    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return this.authorities
    }


    override fun isCredentialsNonExpired(): Boolean {
        return ZonedDateTime.now().toLocalDateTime().minusHours(1).isBefore(loginDateTime)
    }

    override fun isAccountNonExpired(): Boolean {
        return ZonedDateTime.now().toLocalDateTime().minusHours(1).isAfter(loginDateTime)
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}