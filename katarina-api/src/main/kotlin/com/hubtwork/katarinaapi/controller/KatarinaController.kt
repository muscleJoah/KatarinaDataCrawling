package com.hubtwork.katarinaapi.controller

import com.hubtwork.katarinaapi.config.WebClientConfig
import com.hubtwork.katarinaapi.dto.riotapi.DataCrawling.UserDTO
import com.hubtwork.katarinaapi.dto.riotapi.DataCrawling.UserWithMatchDTO
import com.hubtwork.katarinaapi.dto.riotapi.v3.champion.ChampionInfoDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.league.LeagueEntryDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.league.LeagueItemDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.league.LeagueListDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.match.MatchDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.match.MatchTimelineDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.match.MatchlistDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.platformdata.PlatformDataDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.summoners.SummonerDTO
import com.hubtwork.katarinaapi.service.DataCrawling.DataCrawling
import com.hubtwork.katarinaapi.service.katarina.KatarinaApiService
import com.hubtwork.katarinaapi.service.DataCrawling.DataCrawlingService
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
class KatarinaController(private val katarinaApiService: KatarinaApiService , private val riotApiService: RiotApiService , private val dataCrawlingService: DataCrawlingService ,  private val dataCrawling: DataCrawling){


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
   val challengerLeagueList : LeagueListDTO?  = riotApiService.getChallengerLeague(DataCrawlingService.rankedSolo).body
    val grandMasterLeagueList : LeagueListDTO? = riotApiService.getGrandMasterLeague(DataCrawlingService.rankedSolo).body
    val masterLeagueList : LeagueListDTO? = riotApiService.getMasterLeague(DataCrawlingService.rankedSolo).body


    @GetMapping("/getcham")
    fun getChampionRotationRest(): ResponseEntity<ChampionInfoDTO> {
       val championRotation:ChampionInfoDTO? = riotApiService.getChampionRotations()
        return ResponseEntity(championRotation, HttpStatus.OK)

    }

    @GetMapping("/getchallenger/{queue}")
    /*fun getChallengerLeague(@PathVariable("queue") queue:String): ResponseEntity<LeagueListDTO>{
        val challengerLeague: LeagueListDTO = riotApiService.getChallengerLeague(queue)
        return ResponseEntity(challengerLeague,HttpStatus.OK)
    }*/
    fun getChallengerLeague(@PathVariable("queue")queue:String) = riotApiService.getChallengerLeague(queue)

    @GetMapping("/getgrandmaster/{queue}")
    fun getGrandMasterLeague(@PathVariable("queue") queue:String): ResponseEntity<LeagueListDTO>{
        val grandmasterleague: LeagueListDTO? = riotApiService.getGrandMasterLeague(queue).body
        return ResponseEntity(grandmasterleague,HttpStatus.OK)
    }

    @GetMapping("/getmaster/{queue}")
    fun getMasterLeague(@PathVariable("queue") queue:String): ResponseEntity<LeagueListDTO>
    = riotApiService.getMasterLeague(queue)
    /*{
        val masterleague: LeagueListDTO = riotApiService.getMasterLeague(queue)
        return ResponseEntity(masterleague,HttpStatus.OK)
    }*/

    @GetMapping("/getleague/{queue}")
    fun getAllLeague(
        @PathVariable("queue") queue: String,
        @RequestParam("tier") tier: String ,
        @RequestParam("division") division : String) =
        riotApiService.getAllLeague(queue,tier,division)


    @GetMapping("/getleagueid/{leagueid}")
    fun getLeaguebyLeagueId(@PathVariable("leagueid") leagueid: String): ResponseEntity<LeagueListDTO>
    = riotApiService.getLeagueByLeagueId(leagueid)
    /*{
        val leaguebyleagueid : LeagueListDTO? = riotApiService.getLeagueByLeagueId(leagueid)
        return ResponseEntity(leaguebyleagueid,HttpStatus.OK)
    }*/

    @GetMapping("/getleguesummonerid/{encryptedsummonerid}")
    fun getLeagueBysummonerId(@PathVariable("encryptedsummonerid") encryptedsummonerid : String) =
        riotApiService.getLeagueBySummonerId(encryptedsummonerid)

    @GetMapping("/platformstatus")
    fun getPlatformStatus(): ResponseEntity<PlatformDataDTO> {
        val platformstatus : PlatformDataDTO? = riotApiService.getPlatformStatus().body
        return ResponseEntity(platformstatus, HttpStatus.OK)
    }

    @GetMapping("/getmatchbyid/{matchid}")
    fun getMatchById(@PathVariable("matchid")matchId : Long): ResponseEntity<MatchDTO> {
        val matchbyid = riotApiService.getMatchById(matchId).body
        return ResponseEntity(matchbyid, HttpStatus.OK)
    }

    @GetMapping("/getmatchtimeline/{matchid}")
    fun getMatchTimelinebyId(@PathVariable("matchid")matchId: Long): ResponseEntity<MatchTimelineDTO> {
        val matchtimelinebyid = riotApiService.getMatchTimelineById(matchId).body
        return ResponseEntity(matchtimelinebyid, HttpStatus.OK)
    }


    @GetMapping("/getmatchaccountid/{encryptedaccountid}")
    fun getMatchByAccountId(@PathVariable("encryptedaccountid") encryptedAccountId:String): ResponseEntity<MatchlistDTO> {
        val matchlistbyaccountid = riotApiService.getMatchListByAccountId(encryptedAccountId).body
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
        val summonerbyaccountid = riotApiService.getSummonerByAccountId(encryptedAccountId).body
        return ResponseEntity(summonerbyaccountid , HttpStatus.OK)
    }

    @GetMapping("/getsummonerbysummonerid/{summonerid}")
    fun getSummonerBySummonerId(@PathVariable("summonerid") encryptedSummonerId : String): ResponseEntity<SummonerDTO> {
        val summonerid = riotApiService.getSummonerBySummonerId(encryptedSummonerId).body
        return ResponseEntity(summonerid , HttpStatus.OK)
    }


    @GetMapping("/datacrawlingservice/test/getchallengerleaguelist")
    fun getChallengerLeagueListTest(): ResponseEntity<LeagueListDTO> {
        val challengerLeagueList : LeagueListDTO? = riotApiService.getChallengerLeague("RANKED_SOLO_5x5").body
        dataCrawlingService.getChallengerLeagueSummonerIdListTest(challengerLeagueList)
        return ResponseEntity(challengerLeagueList , HttpStatus.OK)
}
    @GetMapping("/datacrawlingservice/test/getaccountidbysummonerid")
    fun getAccountIdBySummonerIdListTest(): ResponseEntity<List<Pair<String, String>>> {
        val summonerIdList : List<Pair<String,String>> = dataCrawlingService.getAccountIdBySummonerIdListTest()
        return ResponseEntity(summonerIdList, HttpStatus.OK)
    }

    @GetMapping("/datacrawlingservice/test/getmatchbyaccountidlist")
    fun getMatchByAccountIdListTest (): ResponseEntity<List<Long>> {
        var matchList : List<Long> = dataCrawlingService.getMatchByAccountIdListTest()
        return ResponseEntity(matchList,HttpStatus.OK)

    }

    @GetMapping("/datacrawlingservice/test/getaccountidinmatchlist")
    fun getAccountInMatchListTest(): ResponseEntity<List<Pair<String, String?>>> {
        var accountList : List<Pair<String, String?>> = dataCrawlingService.getAccountIdInMatchListTest()
        return ResponseEntity(accountList,HttpStatus.OK)
    }


    @GetMapping("datacrawlingserivce/getleaguelist")
    fun getLeagueSummonerList(): ResponseEntity<LeagueListDTO> {
        dataCrawlingService.getLeagueSummonerIdList(challengerLeagueList)
        return ResponseEntity(challengerLeagueList, HttpStatus.OK)
    }


    @GetMapping("dataccrawlingservice/getaccountidlist")
    fun getAccountIdListBySummonerId() {
        dataCrawlingService.getAccountIdBySummonerIdList(dataCrawlingService.getLeagueSummonerIdList(challengerLeagueList))
    }


    @GetMapping("datacrawlingservice/getmatchlist")
    fun getMatchListByAccountId(){
        dataCrawlingService.getMatchByAccountIdList(dataCrawlingService.getAccountIdBySummonerIdList(dataCrawlingService.getLeagueSummonerIdList(challengerLeagueList)))
        //dataCrawlingService.getMatchByAccountIdList(dataCrawlingService.getAccountIdBySummonerIdList(summonerIdList))
    }

    @GetMapping("datacrawlingservice/getuserlistinmatch")
    fun getUserListInMatch(): ResponseEntity<List<UserDTO>> {
        val summonerIdList : List<String> = listOf("qidG3GqBtFuYiIxpH7ub9A0jUbH79-lhPJhFO5oDaZRIfDo")


        //var temp : List<UserDTO> = dataCrawlingService.getUserInfoInMatchList(dataCrawlingService.getMatchByAccountIdList(dataCrawlingService.getAccountIdBySummonerIdList(dataCrawlingService.getLeagueSummonerIdList(challengerLeagueList))))
        var temp : List<UserDTO> = dataCrawlingService.getUserInfoInMatchList(dataCrawlingService.getMatchByAccountIdList(dataCrawlingService.getAccountIdBySummonerIdList(summonerIdList)))
        return ResponseEntity(temp, HttpStatus.OK)

    }

    @GetMapping("datacrawlingservice/getwiserwithmatch")
    fun getUserWithMatchInMatchList(): ResponseEntity<List<UserWithMatchDTO>> {
        val summonerIdList : List<String> = listOf("qidG3GqBtFuYiIxpH7ub9A0jUbH79-lhPJhFO5oDaZRIfDo")

        var temp : List<UserWithMatchDTO> = dataCrawlingService.getUserWithMatchInMatchList(dataCrawlingService.getMatchByAccountIdList(dataCrawlingService.getAccountIdBySummonerIdList(summonerIdList)))
        return ResponseEntity(temp,HttpStatus.OK)
    }


    @GetMapping("datacrawlingservice/datacrawling")
    fun dataCrawling(){
        var userWithMatch = mutableListOf<UserWithMatchDTO>()
        var userInfos= mutableListOf<UserDTO>()     

        dataCrawling.dataCrawling("TRbDETdnv0Prg86D0n5afVUzGZzKM3GqZZA1Kx2VqHk")
    }
}




