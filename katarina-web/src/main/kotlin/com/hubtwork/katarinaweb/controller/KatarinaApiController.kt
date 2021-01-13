package com.hubtwork.katarinaweb.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/katarina")
class KatarinaApiController {

    @GetMapping
    fun controllerRootDir() =
        " API 메인 페이지 "


}