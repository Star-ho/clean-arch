package com.dreamStore.member

import com.dreamStore.member.request.RegisterMemberRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/member")
class MemberController(
    private val memberService: MemberService,
) {
    @PostMapping
    fun registerProduct(@RequestBody registerMemberRequest: RegisterMemberRequest){
        return memberService.registerMember(registerMemberRequest.toEntity())
    }
}