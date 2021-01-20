package com.hubtwork.katarinaapi.service.riot.`interface`

import com.hubtwork.katarinaapi.dto.riotapi.v4.league.LeagueListDTO

interface LeagueV4 {

    fun getChallengerLeague(queue: String): LeagueListDTO?
    fun getGrandMasterLeague(queue: String): LeagueListDTO?
    fun getMasterLeague(queue: String): LeagueListDTO?
    fun getAllLeague(queue: String, tier: String, division: String): LeagueListDTO?

    fun getLeagueByLeagueId(leagueId: String): LeagueListDTO?
    fun getLeagueBySummonerId(encryptedSummonerId: String): LeagueListDTO?

}