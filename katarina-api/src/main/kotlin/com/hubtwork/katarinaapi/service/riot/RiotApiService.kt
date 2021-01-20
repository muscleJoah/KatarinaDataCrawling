package com.hubtwork.katarinaapi.service.riot

import com.hubtwork.katarinaapi.dto.riotapi.v4.match.MatchlistDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.summoners.SummonerDTO
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder


@Service
class RiotApiService(private val restTemplate: RestTemplate, private val webClient: WebClient)

{

    companion object {

        // v4 - summoner
        const val summoner_by_name = "/lol/summoner/v4/summoners/by-name/"
        const val summoner_by_account = "/lol/summoner/v4/summoners/by-account/"
        const val summoner_by_puuid = "/lol/summoner/v4/summoners/by-puuid/"
        const val summoner_by_summonerId = "/lol/summoner/v4/summoners/"

        // v4 - league
        const val league_by_leagueId = "https://kr.api.riotgames.com/lol/league/v4/leagues/"
        const val leagueInfo_by_summonerId = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"
        const val leagueEntry_by_param = "https://kr.api.riotgames.com/lol/league/v4/entries/"

        const val challenger_league = "https://kr.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/"
        const val grandmaster_league = "https://kr.api.riotgames.com/lol/league/v4/grandmasterleagues/by-queue/"
        const val master_league = "https://kr.api.riotgames.com/lol/league/v4/masterleagues/by-queue/"

        // v4 - match
        const val match_by_matchId = "/lol/match/v4/matches/"
        const val match_by_accountId = "/lol/match/v4/matchlists/by-account/"
        const val match_timeline_by_matchId = "/lol/match/v4/timelines/by-match/"




        fun uriParameterBuilder(params: Map<String, String>): String {
            var uriComponents: UriComponentsBuilder = UriComponentsBuilder.newInstance()
            for ((k, v) in params) {
                uriComponents = uriComponents.queryParam(k, v)
            }
            return uriComponents.build().toUriString()
        }
    }

    fun getRecentMatchDetailsBySummonerName(summonerName: String) {
        val summoner: ResponseEntity<SummonerDTO> = restTemplate.exchange(
            "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$summonerName",
            HttpMethod.GET, null, SummonerDTO::class)
        println(summoner.body)
        val matches: ResponseEntity<MatchlistDTO> = restTemplate.exchange(
            "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/${summoner.body!!.accountId}?endIndex=5&beginIndex=0",
            HttpMethod.GET, null, MatchlistDTO::class)
        val matchList = matches.body!!.matches.map { it.gameId.toString() }

        println(matchList)
    }


}