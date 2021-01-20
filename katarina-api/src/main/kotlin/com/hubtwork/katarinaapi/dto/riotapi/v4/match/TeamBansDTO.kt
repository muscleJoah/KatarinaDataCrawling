package com.hubtwork.katarinaapi.dto.riotapi.v4.match

data class TeamBansDTO(
    var pickTurn: Int,      // 픽 순서
    var championId: Int     // 밴픽 챔피언
)

