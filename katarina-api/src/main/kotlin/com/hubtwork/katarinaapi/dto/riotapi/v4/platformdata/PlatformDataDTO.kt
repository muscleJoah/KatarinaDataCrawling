package com.hubtwork.katarinaapi.dto.riotapi.v4.platformdata

data class PlatformDataDTO(

    var id: String,
    var name: String?,
    var locales: ArrayList<String>?,
    var maintenances: ArrayList<StatusDTO>?,
    var incidents: ArrayList<StatusDTO>?

)