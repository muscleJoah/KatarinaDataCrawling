package com.hubtwork.katarinaapi.jpa.domain

import javax.persistence.*


@Entity
@Table(name = "userwithmatchsex")
class UserWithMatch(
    matchId : Long,
    accountId : String)
{
    @Id
    @Column(name = "matchIdsex")
    var matchId: Long = matchId

    @Column(name = "accountIdsex")
    var accountId : String = accountId
}