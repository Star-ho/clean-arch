package com.dreamStore.domain.member.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberJPARepository : JpaRepository<MemberData, Long>