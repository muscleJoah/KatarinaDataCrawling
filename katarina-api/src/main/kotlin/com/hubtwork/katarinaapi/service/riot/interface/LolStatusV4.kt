package com.hubtwork.katarinaapi.service.riot.`interface`

import com.hubtwork.katarinaapi.dto.riotapi.v4.platformdata.PlatformDataDTO
import org.springframework.http.ResponseEntity
import reactor.core.publisher.Mono

interface LolStatusV4 {

    fun getPlatformStatus(): ResponseEntity<PlatformDataDTO>

}