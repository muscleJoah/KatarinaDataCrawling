package com.hubtwork.katarinaapi.service.riot.`interface`

import com.hubtwork.katarinaapi.dto.riotapi.v4.platformdata.PlatformDataDTO

interface LolStatusV4 {

    fun getPlatformStatus(): PlatformDataDTO?

}