package com.hexagonal.auth

import com.hexagonal.member.MemberService
import com.hexagonal.member.dto.CreateMemberDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val memberService: MemberService,
) {

    @PostMapping("/signup")
    fun registerMember(@RequestBody createMemberDto: CreateMemberDto): ResponseEntity<Unit> {
        memberService.registerMember(createMemberDto)
        return ResponseEntity.ok().build()
    }

}