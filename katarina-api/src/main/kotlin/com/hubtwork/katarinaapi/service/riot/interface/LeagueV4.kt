package com.hubtwork.katarinaapi.service.riot.`interface`

import com.hubtwork.katarinaapi.dto.riotapi.v4.league.LeagueEntryDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.league.LeagueListDTO
import org.springframework.http.ResponseEntity
import reactor.core.publisher.Mono

interface LeagueV4 {

    fun getChallengerLeague(queue: String): LeagueListDTO // 일부러 nullable 불가능하게 하였음.
    fun getGrandMasterLeague(queue: String): LeagueListDTO?
    fun getMasterLeague(queue: String):  LeagueListDTO?
    fun getAllLeague(queue: String, tier: String, division: String): ResponseEntity<ArrayList<LeagueEntryDTO>>?

    fun getLeagueByLeagueId(leagueId: String):  LeagueListDTO?
    fun getLeagueBySummonerId(encryptedSummonerId: String): ResponseEntity<ArrayList<LeagueEntryDTO>>?

}