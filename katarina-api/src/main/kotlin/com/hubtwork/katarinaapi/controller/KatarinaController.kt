package com.hubtwork.katarinaapi.controller

import com.hubtwork.katarinaapi.config.WebClientConfig
import com.hubtwork.katarinaapi.dto.riotapi.v3.champion.ChampionInfoDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.league.LeagueEntryDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.league.LeagueItemDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.league.LeagueListDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.match.MatchDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.match.MatchTimelineDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.match.MatchlistDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.platformdata.PlatformDataDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.summoners.SummonerDTO
import com.hubtwork.katarinaapi.service.katarina.KatarinaApiService
import com.hubtwork.katarinaapi.service.riot.DataCrawlingService
import com.hubtwork.katarinaapi.service.riot.RiotApiService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/api")
class KatarinaController(private val katarinaApiService: KatarinaApiService , private val riotApiService: RiotApiService , private val dataCrawlingService: DataCrawlingService) {

    @GetMapping("/bozi/{summoner_Name}")
    fun getMatchDetails(@PathVariable("summoner_Name") name: String) =
        katarinaApiService.getRecentMatchDetailsBySummonerName(name)

   /* @GetMapping("/getcham")
    fun getChampionRotation(): ResponseEntity<ChampionInfoDTO> {
        val rotation = riotApiService.getChampionRotations()
            ?.flux()
            ?.toStream()
            ?.findFirst()
            ?.orElse(null)
        print(rotation)
        return ResponseEntity(rotation, HttpStatus.OK)
    }
*/
    @GetMapping("/getcham")
    fun getChampionRotationRest(): ResponseEntity<ChampionInfoDTO> {
       val championRotation:ChampionInfoDTO? = riotApiService.getChampionRotations()
        return ResponseEntity(championRotation, HttpStatus.OK)

    }

    @GetMapping("/getchallenger/{queue}")
    fun getChallengerLeague(@PathVariable("queue") queue:String): ResponseEntity<LeagueListDTO>{
        val challengerLeague: LeagueListDTO = riotApiService.getChallengerLeague(queue)
        return ResponseEntity(challengerLeague,HttpStatus.OK)
    }

    @GetMapping("/getgrandmaster/{queue}")
    fun getGrandMasterLeague(@PathVariable("queue") queue:String): ResponseEntity<LeagueListDTO>{
        val grandmasterleague: LeagueListDTO? = riotApiService.getGrandMasterLeague(queue)
        return ResponseEntity(grandmasterleague,HttpStatus.OK)
    }

    @GetMapping("/getmaster/{queue}")
    fun getMasterLeague(@PathVariable("queue") queue:String): ResponseEntity<LeagueListDTO>{
        val masterleague: LeagueListDTO? = riotApiService.getMasterLeague(queue)
        return ResponseEntity(masterleague,HttpStatus.OK)
    }

    @GetMapping("/getleague/{queue}")
    fun getAllLeague(
        @PathVariable("queue") queue: String,
        @RequestParam("tier") tier: String ,
        @RequestParam("division") division : String) =
        riotApiService.getAllLeague(queue,tier,division)


    @GetMapping("/getleagueid/{leagueid}")
    fun getLeaguebyLeagueId(@PathVariable("leagueid") leagueid: String): ResponseEntity<LeagueListDTO> {
        val leaguebyleagueid : LeagueListDTO? = riotApiService.getLeagueByLeagueId(leagueid)
        return ResponseEntity(leaguebyleagueid,HttpStatus.OK)
    }

    @GetMapping("/getleguesummonerid/{encryptedsummonerid}")
    fun getLeagueBysummonerId(@PathVariable("encryptedsummonerid") encryptedsummonerid : String) =
        riotApiService.getLeagueBySummonerId(encryptedsummonerid)

    @GetMapping("/platformstatus")
    fun getPlatformStatus(): ResponseEntity<PlatformDataDTO> {
        val platformstatus : PlatformDataDTO? = riotApiService.getPlatformStatus()
        return ResponseEntity(platformstatus, HttpStatus.OK)
    }

    @GetMapping("/getmatchbyid/{matchid}")
    fun getMatchById(@PathVariable("matchid")matchId : Long): ResponseEntity<MatchDTO> {
        val matchbyid = riotApiService.getMatchById(matchId)
        return ResponseEntity(matchbyid, HttpStatus.OK)
    }

    @GetMapping("/getmatchtimeline/{matchid}")
    fun getMatchTimelinebyId(@PathVariable("matchid")matchId: Long): ResponseEntity<MatchTimelineDTO> {
        val matchtimelinebyid = riotApiService.getMatchTimelineById(matchId)
        return ResponseEntity(matchtimelinebyid, HttpStatus.OK)
    }


    @GetMapping("/getmatchaccountid/{encryptedaccountid}")
    fun getMatchByAccountId(@PathVariable("encryptedaccountid") encryptedAccountId:String): ResponseEntity<MatchlistDTO> {
        val matchlistbyaccountid = riotApiService.getMatchListByAccountId(encryptedAccountId)
        return ResponseEntity(matchlistbyaccountid, HttpStatus.OK)
    }

    @GetMapping("/getsummonerbyname/{summonername}")
    fun getSummonerByName(@PathVariable("summonername") summonerName : String): ResponseEntity<SummonerDTO> {
        val summonerbyname = riotApiService.getSummonerByName(summonerName)
        return ResponseEntity(summonerbyname,HttpStatus.OK)
    }

    @GetMapping("/getsummonerbypuuid/{puuid}")
    fun getSummonerByPUUID(@PathVariable("puuid") PUUID : String): ResponseEntity<SummonerDTO> {
        val summonerbypuuid = riotApiService.getSummonerByPUUID(PUUID)
        return ResponseEntity(summonerbypuuid,HttpStatus.OK)
    }

    @GetMapping("/getsummoerbyaccountid/{accountid}")
    fun getSummonerByAccountId(@PathVariable("accountid") encryptedAccountId: String): ResponseEntity<SummonerDTO> {
        val summonerbyaccountid = riotApiService.getSummonerByAccountId(encryptedAccountId)
        return ResponseEntity(summonerbyaccountid , HttpStatus.OK)
    }

    @GetMapping("/getsummonerbysummonerid/{summonerid}")
    fun getSummonerBySummonerId(@PathVariable("summonerid") encryptedSummonerId : String): ResponseEntity<SummonerDTO> {
        val summonerid = riotApiService.getSummonerBySummonerId(encryptedSummonerId)
        return ResponseEntity(summonerid , HttpStatus.OK)
    }


    @GetMapping("/datacrawlingservice/getchallengerleaguelist")
    fun getChallengerLeagueList(): ResponseEntity<LeagueListDTO> {
        val challengerLeagueList : LeagueListDTO = riotApiService.getChallengerLeague("RANKED_SOLO_5x5")
        dataCrawlingService.getChallengerLeagueSummonerIdList(challengerLeagueList)
        return ResponseEntity(challengerLeagueList , HttpStatus.OK)
}
    @GetMapping("/datacrawlingservice/getaccountidbysummonerid")
    fun getAccountIdBySummonerIdList(): ResponseEntity<List<Pair<String, String>>> {
        val summonerIdList : List<Pair<String,String>> = dataCrawlingService.getAccountIdBySummonerIdList()
        return ResponseEntity(summonerIdList, HttpStatus.OK)
    }

    @GetMapping("/datacrawlingservice/getmatchbyaccountidlist")
    fun getMatchByAccountIdList (): ResponseEntity<List<Long>> {
        var matchList : List<Long> = dataCrawlingService.getMatchByAccountIdList()
        return ResponseEntity(matchList,HttpStatus.OK)

    }

    @GetMapping("/datacrawlingservice/getaccountidinmatchlist")
    fun getAccountInMatchList(): ResponseEntity<List<Pair<String, String>>> {
        var accountList : List<Pair<String, String>> = dataCrawlingService.getAccountIdInMatchList()
        return ResponseEntity(accountList,HttpStatus.OK)
    }
}



