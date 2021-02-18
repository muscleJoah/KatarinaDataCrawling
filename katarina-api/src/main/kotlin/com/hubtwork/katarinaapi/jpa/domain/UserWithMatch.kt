package com.hubtwork.katarinaapi.jpa.domain

import javax.persistence.*


@Entity
@Table(name = "userwithmatch")
class UserWithMatch(
    matchId : Long,
    accountId : String)
{
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0

    @Column(name = "matchId")
    var matchId: Long = matchId

    @Column(name = "accountId")
    var accountId : String = accountId
}