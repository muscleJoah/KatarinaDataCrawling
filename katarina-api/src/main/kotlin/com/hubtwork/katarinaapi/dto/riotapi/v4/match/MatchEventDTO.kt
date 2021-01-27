package com.hubtwork.katarinaapi.dto.riotapi.v4.match

data class MatchEventDTO(
    var laneType: String?,       //  탑 , 미드 , 바텀 ( 포탑 파괴 이벤트 )
    var skillSlot: Int,         //  레벨업한 스킬 슬롯 ID
    var ascendedType: String?,   // ?
    var creatorId: Int,         //  행위 주체 플레이어 ID
    var afterId: Int,           // ?
    var eventType: String?,      //  이벤트 종류

    var participantId: Int,     //  플레이어 ID
    var teamId: Int,            //  팁 ID

    /**
     *          Type : (Legal values)
     *
     * CHAMPION_KILL,
     *
     * WARD_PLACED,
     *
     * WARD_KILL,
     *
     * BUILDING_KILL,
     *
     * ELITE_MONSTER_KILL,
     *
     * ITEM_PURCHASED,
     *
     * ITEM_SOLD,
     *
     * ITEM_DESTROYED,
     *
     * ITEM_UNDO,
     *
     * SKILL_LEVEL_UP,
     *
     * ASCENDED_EVENT,
     *
     * CAPTURE_POINT,
     *
     * PORO_KING_SUMMON
     *
     */
    var type: String,           //  이벤트 종류

    var levelUpType: String?,    //  레벨업 타입 ( 일반적인 레벨업인지, 질리언 패시브 등에 의한 특수한 레벨업인지 )
    var wardType: String?,       //  와드 종류
    var towerType: String?,      //  타워 종류
    var ItemId: Int,            //  아이템 ID
    var beforeId: Int,          // ?
    var pointCaptured: String?,  // ?
    var monsterType: String?,    //  크립 종류 ( 전령, 용, 바론 )
    var monsterSubType: String?, //  크립 종류 ( 추가 정보 )
    var position: MatchPositionDTO?, //  이벤트 발생 위치

    var killerId: Int,          //  킬 플레이어
    var victimId: Int,          //  데스 플레이어
    var assistingParticipantIds: ArrayList<Int>?,     // 어시 플레이어들

    var timestamp: Long,        //  시간
    var buildingType: String?,   // ?
)
