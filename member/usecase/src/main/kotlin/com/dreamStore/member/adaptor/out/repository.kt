package com.dreamStore.member.adaptor.out

import com.dreamstore.member.Member

interface MemberRepositoryAdaptor{
    fun findAll():List<Member>
    fun findById(id:Long): Member?
    fun save(member: Member)
}