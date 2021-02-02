package com.hubtwork.katarinaapi.service.riot.`interface`

import com.hubtwork.katarinaapi.dto.riotapi.v4.summoners.SummonerDTO
import org.springframework.http.ResponseEntity
import reactor.core.publisher.Mono

interface SummonerV4 {

    fun getSummonerByName(summonerName: String): SummonerDTO?
    fun getSummonerByPUUID(encryptedPUUID: String): SummonerDTO?
    fun getSummonerByAccountId(encryptedAccountId: String): ResponseEntity<SummonerDTO>
    fun getSummonerBySummonerId(encryptedSummonerId: String):ResponseEntity<SummonerDTO>

}