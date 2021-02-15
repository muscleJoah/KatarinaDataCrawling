package com.hubtwork.katarinaapi.jpa.respository

import com.hubtwork.katarinaapi.jpa.domain.UserWithMatch
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserWithMatchRepository : JpaRepository<UserWithMatch, Long>