package com.hubtwork.katarinaapi.jpa.domain

import javax.persistence.*


@Entity
@Table(name = "usersex")
class User(summonerName : String,
           summonerId : String,
           accountId : String,
           platformId : String) {

    @Id
    @Column(name = "accountIdsex")
    var accountId: String = accountId

    @Column(name = "summonerNamesex")
    var summonerName: String = summonerName

    @Column(name = "platformIdsex")
    var platformId: String = platformId

    @Column(name = "summonerIdsex")
    var summonerId : String = summonerId
}