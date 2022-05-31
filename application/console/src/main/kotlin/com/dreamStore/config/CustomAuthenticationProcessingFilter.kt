package com.dreamStore.config

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CustomAuthenticationProcessingFilter(defaultFilterProcessesUrl:String): AbstractAuthenticationProcessingFilter(defaultFilterProcessesUrl) {
    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        val memberId = request!!.getParameter("username")
        val password = request.getParameter("password")

        return authenticationManager.authenticate(UsernamePasswordAuthenticationToken(memberId,password))
    }
}