package com.hubtwork.katarinaapi.dto.riotapi.v3.champion

/**
 *          get Champion-Lotation Info
 *
 *          response about "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations"
 *
 *
 */

data class ChampionInfoDTO(

    var freeChampionIds: ArrayList<Int>,                 // 챔피언 로테이션
    var freeChampionIdsForNewPlayers: ArrayList<Int>,   // 신규 유저용 로테이션

    var maxNewPlayerLevel: Int              // 신규 유저 기준 제한 레벨
)

