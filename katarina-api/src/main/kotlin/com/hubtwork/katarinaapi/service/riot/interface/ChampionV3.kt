package com.hubtwork.katarinaapi.service.riot.`interface`

import com.hubtwork.katarinaapi.dto.riotapi.v3.champion.ChampionInfoDTO

interface ChampionV3 {

    fun getChampionRotations(): ChampionInfoDTO?

}