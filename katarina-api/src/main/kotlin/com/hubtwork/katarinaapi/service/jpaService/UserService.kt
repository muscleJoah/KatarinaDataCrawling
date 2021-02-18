package com.hubtwork.katarinaapi.service.jpaService

import com.hubtwork.katarinaapi.jpa.domain.User
import com.hubtwork.katarinaapi.jpa.respository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository : UserRepository) {
    fun create(user : User) =
        repository.save(user)
}