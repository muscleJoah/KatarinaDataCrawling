package com.hubtwork.katarinaapi.service.riot.`interface`

import com.hubtwork.katarinaapi.dto.riotapi.v3.champion.ChampionInfoDTO
import reactor.core.publisher.Mono

interface ChampionV3 {

    fun getChampionRotations(): Mono<ChampionInfoDTO>?

}