package com.hubtwork.katarinaapi.ExceptionHandler

import org.springframework.http.HttpStatus
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Component
import org.springframework.web.client.ResponseErrorHandler


@Component
class ResponseHandler : ResponseErrorHandler {
    override fun hasError(response: ClientHttpResponse): Boolean {

           return response.statusCode == HttpStatus.NOT_FOUND || response.statusCode == HttpStatus.BAD_REQUEST || response.statusCode == HttpStatus.GATEWAY_TIMEOUT
    }


    override fun handleError(response: ClientHttpResponse) {
        if(response.statusCode == HttpStatus.NOT_FOUND){
            println("SEX")
        }
        if(response.statusCode == HttpStatus.GATEWAY_TIMEOUT){
            Thread.sleep(10000)
        }
    }
}