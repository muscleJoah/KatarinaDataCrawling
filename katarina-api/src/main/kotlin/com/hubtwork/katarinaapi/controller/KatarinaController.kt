package com.hubtwork.katarinaapi.controller

import com.hubtwork.katarinaapi.config.WebClientConfig
import com.hubtwork.katarinaapi.service.riot.RiotApiService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api")
class KatarinaController(private val riotApiService: RiotApiService) {

    @GetMapping("/{summoner_Name}")
    fun getMatchDetails(@PathVariable("summoner_Name") name: String) =
        riotApiService.getRecentMatchDetailsBySummonerName(name)



}