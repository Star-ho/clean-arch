package com.dreamStore.member

import com.dreamStore.member.request.MemberRegisterRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/member")
class MemberController(
    private val memberService: MemberService,
) {
    @PostMapping
    fun registerMember(@RequestBody memberRegisterRequest: MemberRegisterRequest){
        return memberService.registerMember(memberRegisterRequest.toEntity())
    }
}