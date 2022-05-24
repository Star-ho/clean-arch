package com.dreamStore.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Bean
    fun encodePassword(): BCryptPasswordEncoder {  // 회원가입 시 비밀번호 암호화에 사용할 Encoder 빈 등록
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers("/auth/**")
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            .authorizeRequests()
            .antMatchers("/**").permitAll()
//            .antMatchers("/admin").hasRole(ROLE.ADMIN.name)
//            .antMatchers("/order/**").authenticated()
            .and()
                .formLogin()
                .loginPage("/auth/login")
                .defaultSuccessUrl("/")
                .permitAll()
            .and()
                .logout()
                .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
    }
}