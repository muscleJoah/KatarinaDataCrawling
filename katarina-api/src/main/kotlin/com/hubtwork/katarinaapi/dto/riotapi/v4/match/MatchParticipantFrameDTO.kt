package com.hubtwork.katarinaapi.dto.riotapi.v4.match

data class MatchParticipantFrameDTO(
    var participantId: Int,     // 플레이어 ID
    var minionsKilled: Int,     // 미니언 처치 수
    var teamScore: Int,         // ?
    var dominionScore: Int,     // ?
    var totalGold: Int,         // 총 골드
    var level: Int,             // 레벨
    var xp: Int,                // 경험치
    var currentGold: Int,       // 현재 골드
    var position: MatchPositionDTO?,     // 플레이어 위치
    var jungleMinionsKilled: Int        // 정글 몹 처치 수
)
