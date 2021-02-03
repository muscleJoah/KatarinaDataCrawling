package com.hubtwork.katarinaapi.service.DataCrawling.Interface

import com.hubtwork.katarinaapi.dto.riotapi.DataCrawling.UserDTO
import com.hubtwork.katarinaapi.dto.riotapi.DataCrawling.UserWithMatchDTO
import com.hubtwork.katarinaapi.dto.riotapi.v4.league.LeagueListDTO

interface DataCrawling {
    fun getLeagueSummonerIdList(leagueTierList: LeagueListDTO?): MutableList<String>
    fun getAccountIdBySummonerIdList(summonerIdList: List<String>): MutableList<String>
    fun getMatchByAccountIdList(accountIdList : List<String>): List<Long>
    fun getUserInfoInMatchList(matchIdList: List<Long>): List<UserDTO>
    fun getMatchListByUserInfo(usersInMatch : List<UserDTO>): List<Long>
    fun getUserWithMatchInMatchList(matchIdList: List<Long>) : List<UserWithMatchDTO>
    fun getMatchByAccountId(matchId : String) : List<Long>
}