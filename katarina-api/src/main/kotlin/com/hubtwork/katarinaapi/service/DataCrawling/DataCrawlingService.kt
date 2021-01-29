package com.hubtwork.katarinaapi.service.DataCrawling

import com.google.gson.Gson
import com.hubtwork.katarinaapi.dto.riotapi.DataCrawling.UserDTO
import com.hubtwork.katarinaapi.dto.riotapi.DataCrawling.UserWithMatchDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.league.LeagueListDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.match.MatchlistDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.match.ParticipantIdentityDTO
import com.hubtwork.katarinaapi.service.katarina.KatarinaApiService
import com.hubtwork.katarinaapi.service.riot.RiotApiService
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import java.util.Scanner
import com.hubtwork.katarinaapi.service.DataCrawling.Interface.DataCrawling



@Service
class DataCrawlingService(private val riotApiService: RiotApiService, private val katarinaApiService: KatarinaApiService) :DataCrawling {

    companion object {

        //Queue type
        const val rankedSolo: String = "RANKED_SOLO_5x5" // Ranked Solo
        const val rankedFlexSR: String = "RANKED_FLEX_SR" // Ranked Flex
        const val rankedFlexTT: String = "RANKED_FLEX_TT" // Team Fight Tactics
    }


    //tier
    val challengerLeagueList: LeagueListDTO = riotApiService.getChallengerLeague(rankedSolo)
    val grandMasterLeagueList: LeagueListDTO = riotApiService.getGrandMasterLeague(rankedSolo)
    val masterLeagueList: LeagueListDTO = riotApiService.getGrandMasterLeague(rankedSolo)

    /*
   * Under functions are just for test.
   * when test ends, delete these codes
    */


    fun getChallengerLeagueSummonerIdListTest(challengerLeagueId: LeagueListDTO): MutableList<Pair<String, String>> {
        var summonerIdArray = mutableListOf<Pair<String, String>>() //Pair < SummonerId, SummonerName>

        challengerLeagueId.entries.forEach {
            summonerIdArray.add(Pair(it.summonerId, it.summonerName))
        }
        summonerIdArray.forEach {
            println(it)
        }

        return summonerIdArray
    }

    fun getAccountIdBySummonerIdListTest( /*summonerIdArray : List<Pair<String,String>>*/): MutableList<Pair<String, String>> {

        val summonerIdArray: List<Pair<String, String>> = getChallengerLeagueSummonerIdListTest(challengerLeagueList)
        var accountIdArray = mutableListOf<Pair<String, String>>() // Pair < AccountId, summonerName>

        summonerIdArray.forEach {
            accountIdArray.add(
                Pair(
                    riotApiService.getSummonerBySummonerId(it.first).accountId,
                    it.second
                )
            ) //account id, summoner name 쌍으로 저장.
        }

        accountIdArray.forEach {
            println(it)
        }

        return accountIdArray
    }

    fun getMatchByAccountIdListTest(): List<Long> {
        val accountIdArray: List<Pair<String, String>> = getAccountIdBySummonerIdListTest()
        var matchIdList = mutableListOf<Long>()
        accountIdArray.forEach {
            riotApiService.getMatchListByAccountId(it.first).matches.forEach {
                matchIdList.add(it.gameId)
            }
        }
        matchIdList.forEach {
            println(it)
        }

        return matchIdList.distinct()
    }

    fun getAccountIdInMatchListTest(): List<Pair<String, String>> {
        var accountIdList = mutableListOf<Pair<String, String>>()
        val a: Long = 4950904382
        val b: Long = 4950950198
        var matchIdList = listOf<Long>(a, b)//getMatchByAccountIdList()
        var playerAccountIdList = mutableListOf<Pair<String, String>>() // Pair<accountId, summonerName>
        matchIdList.forEach {
            riotApiService.getMatchById(it).participantIdentities.forEach {
                playerAccountIdList.add(Pair(it.player.accountId, it.player.summonerName))
            }
        }
        println(playerAccountIdList.distinct())

        return playerAccountIdList.distinct()
    }

    /*
*
* Test functions end , functions & codes under these Remark
* are not for test, for real work
*

 */
    override fun getLeagueSummonerIdList(leagueTierList: LeagueListDTO): MutableList<String> {
        var summonerIdList = mutableListOf<String>()// summoner Id 저장용 List
        leagueTierList.entries.forEach {
            summonerIdList.add(it.summonerId)
        }
       // summonerIdList.forEach { println(it) }
        return summonerIdList
    }

    override fun getAccountIdBySummonerIdList(summonerIdList: List<String>): MutableList<String> {
        var accountIdList = mutableListOf<String>()//AccountId 저장용 LIst
        summonerIdList.forEach {
            accountIdList.add(riotApiService.getSummonerBySummonerId(it).accountId) //account id, summoner name 쌍으로 저장.
        }
        //accountIdList.forEach{println("응애 $it")}
        return accountIdList
    }

    override fun getMatchByAccountIdList(accountIdList : List<String>): List<Long> {
        var matchIdList = mutableListOf<Long>()
        accountIdList.forEach{
            riotApiService.getMatchListByAccountId(it).matches.forEach{
                matchIdList.add(it.gameId)
                Thread.sleep(1000)
            }
        }
      // matchIdList.distinct().forEach{println(it)
       // Thread.sleep(100)}

        return matchIdList.distinct() //매치아이디 중복제거해서보내드리겠읍니다..

    }

    override fun getUserInfoInMatchList(matchIdList: List<Long>): List<UserDTO> {

      //  val exMatchId : Long = 4940168480
        var usersInMatch = mutableListOf<UserDTO>()
        matchIdList.forEach {
            var players: MutableList<ParticipantIdentityDTO> = riotApiService.getMatchById(it).participantIdentities
            Thread.sleep(100)
            players.forEach {
                var temp: UserDTO = UserDTO(it.player.summonerName, it.player.summonerId, it.player.accountId, it.player.platformId)
                usersInMatch.add(temp)
                Thread.sleep(1200)
            }
        }
        println("끝끝끝끝끝끝끄튺튺ㅌ끝끄튺튺튺튺트끝끄튺트끝끄튺튺ㅌ끄튺튺끝끝끝끄튺튺튺끝끝끝끝끝끝ㄲ끝")
        return usersInMatch.distinct()
        }

    override fun getUserWithMatchInMatchList(matchIdList: List<Long>) : List<UserWithMatchDTO>{

        var userWithMatch = mutableListOf<UserWithMatchDTO>()
        matchIdList.forEach{
            var temp : UserWithMatchDTO
            var participantIds = mutableListOf<String>()
            var players : MutableList<ParticipantIdentityDTO> = riotApiService.getMatchById(it).participantIdentities

            players.forEach{
                participantIds.add(it.player.accountId)
            }
            userWithMatch.add(UserWithMatchDTO(it, participantIds))
        }
        return userWithMatch.distinct()
    }


    override fun getMatchListByUserInfo(usersInMatch : List<UserDTO>): List<Long> { // List<UserDTO>에서 매치리스트 뽑아오는 함수>
        var accountIdList = mutableListOf<String>()
        val matchIdList : List<Long>

        usersInMatch.forEach{
            accountIdList.add(it.accountId)
        }


        return getMatchByAccountIdList(accountIdList)

    }
}


