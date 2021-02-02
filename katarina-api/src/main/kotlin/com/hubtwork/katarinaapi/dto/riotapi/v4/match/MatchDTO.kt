package com.hubtwork.katarinaapi.dto.riotapi.v4.match

/**
 *              get Detail DATA about particular Match
 *
 *  response about "https://kr.api.riotgames.com/lol/match/v4/matches/{matchId}"
 */
data class MatchDTO(
    var gameId: Long,       // matchID
    var platformId: String, // 플랫폼 Locale
    var seasonID: Int,      // 시즌 정보
    var gameVersion: String,// 클라이언트 버전

    var gameCreation: Long, // 매치 시작 시간
    var gameDuration: Long, // 매치 지속 시간 ( sec )
    /**
     *  Queue Reference ID
     *  ( info about Endpoint :: [ GET ] http://static.developer.riotgames.com/docs/lol/queues.json )
     *
     *  ex_
     *      {
    "queueId": 420,
    "map": "Summoner's Rift",
    "description": "5v5 Ranked Solo games",
    "notes": null
    },
     *
     *  Map Reference ID
     *  ( info about Endpoint :: [ GET ] http://static.developer.riotgames.com/docs/lol/maps.json )
     *
     *  ex_
     *      {
    "mapId": 11,
    "mapName": "Summoner's Rift",
    "notes": "Current Version"
    },
     *
     *  Game Type Key
     *  ( info about Endpoint :: [ GET ] http://static.developer.riotgames.com/docs/lol/gameTypes.json )
     *
     *  ex_
     *      {
    "gametype": "MATCHED_GAME",
    "description": "all other games"
    },
     */
    var gameType: String,
    var queueId: Int,
    var mapId: Int,

    var teams: ArrayList<TeamStatsDTO>,                             // 팀별 요약
    var participants: ArrayList<ParticipantDTO>,        // 소환사 별 게임 내 디테일 정보
    var participantIdentities: ArrayList<ParticipantIdentityDTO>    // 소환사 관련 간략 정보 ( 소환사명 아이콘 등 )

)
{
    fun getStartTime(): Long = gameCreation
}