package com.hubtwork.katarinaapi.service.batch

import com.hubtwork.katarinaapi.jpa.domain.User
import com.hubtwork.katarinaapi.service.jpaService.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import javax.persistence.Column
import javax.persistence.Id

@Service
class MatcherService(private val userService: UserService) {
    companion object {
        private val logger: org.slf4j.Logger? = LoggerFactory.getLogger(MatcherService::class.java)
    }
    fun insertUser(accountId : String, summonerName : String?, platformId:String?, summonerId:String?){
        val userInfo = User(accountId, summonerName, platformId, summonerId)
        val saved = userService.create(userInfo)
        logger?.info("[ user ] ${saved.accountId} enrolled Successfull")
    }
}
