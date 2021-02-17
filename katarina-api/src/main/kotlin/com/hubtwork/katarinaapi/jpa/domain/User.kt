package com.hubtwork.katarinaapi.jpa.domain

import javax.persistence.*


@Entity
@Table(name = "user")
class User(summonerName : String,
           summonerId : String,
           accountId : String,
           platformId : String) {

    @Id
    @Column(name = "accountId")
    var accountId: String = accountId

    @Column(name = "summonerName")
    var summonerName: String = summonerName

    @Column(name = "platformId")
    var platformId: String = platformId

    @Column(name = "summonerId")
    var summonerId : String = summonerId
}