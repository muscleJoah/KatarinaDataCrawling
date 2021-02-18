package com.hubtwork.katarinaapi.service.jpaService

import com.hubtwork.katarinaapi.jpa.domain.UserWithMatch
import com.hubtwork.katarinaapi.jpa.respository.UserWithMatchRepository
import org.springframework.stereotype.Service

@Service
class UserWithMatchService(private val repository : UserWithMatchRepository) {
    fun create(userWithMatch : UserWithMatch) =
        repository.save(userWithMatch)
}