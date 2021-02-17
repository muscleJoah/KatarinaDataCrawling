package com.hubtwork.katarinaapi.service.DataCrawling

import com.hubtwork.katarinaapi.Object.DataCrawlingObjects
import org.springframework.stereotype.Service

@Service
class DataCrawling(private val dataCrawlingService: DataCrawlingService ) {

    var objects : DataCrawlingObjects = DataCrawlingObjects()
    fun dataCrawling(accountId : String)
    {
        val matchIdList : List<Long> = dataCrawlingService.getAllOfMatchByAccountId(accountId)

        dataCrawlingService.getUserWithMatchInMatchList(matchIdList).forEach{
            objects.userWithMatch?.add(it)
        }
        dataCrawlingService.getUserInfoInMatchList(matchIdList).forEach{
            objects.userInfos?.add(it)
        }

    }

}

  /*  fun dataCrawling(userInfos: MutableList<UserDTO>, userWithMatch: MutableList<UserWithMatchDTO>, isFirst: Boolean) {


        if (isFirst) {
            val summonerIdList : List<String> = listOf("qidG3GqBtFuYiIxpH7ub9A0jUbH79-lhPJhFO5oDaZRIfDo")
            val challengerLeagueIdList: MutableList<String> =
                dataCrawlingService.getLeagueSummonerIdList(dataCrawlingService.challengerLeagueList) // 챌린저리그 summonerId 리스트.
          //  val accountIdList: MutableList<String> =
          //      dataCrawlingService.getAccountIdBySummonerIdList(challengerLeagueIdList) // summoner Id -> Accouunt Id
            val accountIdList : MutableList<String> =
                dataCrawlingService.getAccountIdBySummonerIdList(summonerIdList)

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

    }*/