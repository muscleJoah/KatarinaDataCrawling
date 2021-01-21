package com.hubtwork.katarinaapi.service.riot.`interface`

import com.hubtwork.katarinaapi.dto.riotapi.v4.summoners.SummonerDTO
import reactor.core.publisher.Mono

interface SummonerV4 {

    fun getSummonerByName(summonerName: String): Mono<SummonerDTO>?
    fun getSummonerByPUUID(encryptedPUUID: String): Mono<SummonerDTO>?
    fun getSummonerByAccountId(encryptedAccountId: String): Mono<SummonerDTO>?
    fun getSummonerBySummonerId(encryptedSummonerId: String): Mono<SummonerDTO>?

}