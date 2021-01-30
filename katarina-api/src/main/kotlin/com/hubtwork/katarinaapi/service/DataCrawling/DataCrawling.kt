package com.hubtwork.katarinaapi.service.DataCrawling

import com.hubtwork.katarinaapi.dto.riotapi.DataCrawling.UserDTO
import com.hubtwork.katarinaapi.dto.riotapi.DataCrawling.UserWithMatchDTO
import org.springframework.stereotype.Service

@Service
class DataCrawling(private val dataCrawlingService: DataCrawlingService ) {


    fun dataCrawling(userInfos: MutableList<UserDTO>, userWithMatch: MutableList<UserWithMatchDTO>, isFirst: Boolean) {


        if (isFirst) {
            val challengerLeagueIdList: MutableList<String> =
                dataCrawlingService.getLeagueSummonerIdList(dataCrawlingService.challengerLeagueList) // 챌린저리그 summonerId 리스트.
            val accountIdList: MutableList<String> =
                dataCrawlingService.getAccountIdBySummonerIdList(challengerLeagueIdList) // summoner Id -> Accouunt Id
            val matchIdList: List<Long> = dataCrawlingService.getMatchByAccountIdList(accountIdList) // matchIdList



            dataCrawlingService.getUserInfoInMatchList(matchIdList).forEach {
                userInfos.add(it)
            }
            dataCrawlingService.getUserWithMatchInMatchList(matchIdList).forEach {
                userWithMatch.add(it)
            }
            dataCrawling(userInfos , userWithMatch, false)
        }
        else {
            var accountIdList = mutableListOf<String>()

            userInfos.forEach{
                accountIdList.add(it.accountId)
            }
            val matchIdList: List<Long> = dataCrawlingService.getMatchByAccountIdList(accountIdList)

            dataCrawlingService.getUserInfoInMatchList(matchIdList).forEach {
                userInfos.add(it)
            }
            dataCrawlingService.getUserWithMatchInMatchList(matchIdList).forEach {
                userWithMatch.add(it)
            }

            dataCrawling(userInfos , userWithMatch, false)
        }

    }
}