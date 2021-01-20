package com.hubtwork.katarinaapi.dto.riotapi.v4.match


data class MatchTimelineDTO(
    // 매치 프레임 정보
    var frames: ArrayList<MatchFrameDTO> = arrayListOf(),
    var frameIntervals: Long            // 매치 프레임간 간격 ( 60000 = 1분 )
)

