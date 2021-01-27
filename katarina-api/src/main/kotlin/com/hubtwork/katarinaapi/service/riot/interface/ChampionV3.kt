package com.hubtwork.katarinaapi.service.riot.`interface`

import com.hubtwork.katarinaapi.dto.riotapi.v3.champion.ChampionInfoDTO
import org.springframework.http.ResponseEntity
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ChampionV3 {

    fun getChampionRotations():ChampionInfoDTO?

}