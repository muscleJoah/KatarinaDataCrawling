package com.hubtwork.katarinaapi.service.riot.`interface`

import com.hubtwork.katarinaapi.dto.riotapi.v4.summoners.SummonerDTO

interface SummonerV4 {

    fun getSummonerByName(summonerName: String): SummonerDTO?
    fun getSummonerByPUUID(encryptedPUUID: String): SummonerDTO?
    fun getSummonerByAccountId(encryptedAccountId: String): SummonerDTO?
    fun getSummonerBySummonerId(encryptedSummonerId: String): SummonerDTO?

}