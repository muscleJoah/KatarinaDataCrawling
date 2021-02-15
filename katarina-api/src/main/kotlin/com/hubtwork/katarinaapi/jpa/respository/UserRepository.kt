package com.hubtwork.katarinaapi.jpa.respository

import com.hubtwork.katarinaapi.jpa.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, String>