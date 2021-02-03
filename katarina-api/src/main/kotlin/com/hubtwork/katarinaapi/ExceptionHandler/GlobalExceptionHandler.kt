package com.hubtwork.katarinaapi.ExceptionHandler

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.lang.RuntimeException
import kotlin.math.log


@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(value = [RuntimeException::class])
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun exception404(e : RuntimeException): String {
        return "404 NOT FOUND \ncheck URI again "
    }

}