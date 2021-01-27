package com.hubtwork.katarinaapi.dto.riotapi.v4.match

data class MatchFrameDTO(

    var timestamp: Long,
    var participantFrames: Map<String, MatchParticipantFrameDTO> = mapOf(),
    var events: ArrayList<MatchEventDTO>? = arrayListOf()

)