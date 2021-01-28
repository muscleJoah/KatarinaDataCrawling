package com.hubtwork.katarinaapi.service.riot

import com.google.gson.Gson
import com.hubtwork.katarinaapi.dto.riotapi.v4.league.LeagueListDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.match.MatchlistDTO
import com.hubtwork.katarinaapi.service.katarina.KatarinaApiService
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import java.util.Scanner



@Service
class DataCrawling(private val riotApiService: RiotApiService, private val katarinaApiService: KatarinaApiService)
{
/*
    companion object{
        const val rankedSolo : String = "RANKED_SOLO_5x5"
        const val rankedFlexSR : String = "RANKED_FLEX_SR"
        const val rankedFlexTT : String = "RANKED_FLEX_TT"


    }

    val challengerLeagueList : LeagueListDTO  = riotApiService.getChallengerLeague(rankedSolo)

    fun getChallengerLeagueSummonerIdList(challengerLeagueId : LeagueListDTO): MutableList<Pair<String, String>> {
        var summonerIdArray = mutableListOf<Pair<String, String>>() //Pair < SummonerId, SummonerName>

        challengerLeagueId.entries.forEach{
            summonerIdArray.add(Pair(it.summonerId, it.summonerName))
        }
        summonerIdArray.forEach{
            println(it)
        }

        return summonerIdArray
    }

    fun getAccountIdBySummonerIdList ( /*summonerIdArray : List<Pair<String,String>>*/): MutableList<Pair<String, String>> {

        val summonerIdArray : List<Pair<String, String>> = getChallengerLeagueSummonerIdList(challengerLeagueList)
        var accountIdArray = mutableListOf<Pair<String,String>>() // Pair < AccountId, summonerName>

        summonerIdArray.forEach{
            accountIdArray.add(Pair(riotApiService.getSummonerBySummonerId(it.first).accountId , it.second)) //account id, summoner name 쌍으로 저장.
        }

        accountIdArray.forEach{
            println(it)
        }

        return accountIdArray
    }

    fun getMatchByAccountIdList(): List<Long> {
        val accountIdArray : List<Pair<String, String>> = getAccountIdBySummonerIdList()
        var matchIdList  = mutableListOf<Long>()
        accountIdArray.forEach{
            riotApiService.getMatchListByAccountId(it.first).matches.forEach {
                matchIdList.add(it.gameId)
            }
        }
            matchIdList.forEach{
                println(it)
            }

            return matchIdList.distinct()
        }
/*
    fun getAccountIdInMatchList (): List<Pair<String, String>> {
        var accountIdList = mutableListOf<Pair<String,String>>()
        val a : Long = 4950904382
        val b : Long = 4950950198
        var matchIdList   = listOf<Long>(a,b)//getMatchByAccountIdList()
        var playerAccountIdList = mutableListOf<Pair<String,String>>() // Pair<accountId, summonerName>
        matchIdList.forEach{
            riotApiService.getMatchById(it).participantIdentities.forEach{
               playerAccountIdList.add(Pair(it.player.accountId , it.player.summonerName)  )
            }
        }
        println(playerAccountIdList.distinct())

        return playerAccountIdList.distinct()
    }*/
*/
    }


