package com.hubtwork.katarinaapi.config

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hubtwork.katarinaapi.ExceptionHandler.ResponseHandler
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.retry.RetryCallback
import org.springframework.retry.RetryContext
import org.springframework.retry.RetryListener
import org.springframework.retry.backoff.ExponentialBackOffPolicy
import org.springframework.retry.support.RetryTemplate
import org.springframework.web.client.ResponseErrorHandler
import org.springframework.web.client.RestTemplate
import java.util.concurrent.TimeUnit
import org.springframework.retry.backoff.FixedBackOffPolicy
import org.springframework.retry.listener.RetryListenerSupport
import org.springframework.retry.policy.AlwaysRetryPolicy

import org.springframework.retry.policy.SimpleRetryPolicy





@Configuration
class RestTemplateConfig(private val restTemplateBuilder: RestTemplateBuilder) {

    @Value("\${riot.api-key}")
    lateinit var riotToken: String

    private fun createFactory() : ClientHttpRequestFactory {
        var factory = HttpComponentsClientHttpRequestFactory()
        factory.setConnectTimeout(20000)
        factory.setReadTimeout(20000)    // read timeout

        var httpClient = HttpClientBuilder.create()
            .setMaxConnPerRoute(50) // Connection pool on Route
            .setMaxConnTotal(300)   // Connection pool : Max Connection Pool
            // Idle Connection Shutdown on periodically, Killed unused connection on keep-alive time.
            .evictIdleConnections(20000L, TimeUnit.MILLISECONDS)
            .build()
        factory.httpClient = httpClient
        return factory
    }

    /**
     *          TODO - Setting for restTemplate ( HTTP Connections, etc...
     *
     */
    @Bean
    fun restTemplate( responseHandler: ResponseHandler): RestTemplate {
        val restTemplate = restTemplateBuilder
            .defaultHeader("X-Riot-Token", riotToken)
            .defaultHeader("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8")
          //.errorHandler(responseHandler)
            .build()
        restTemplate.requestFactory = createFactory()
        return restTemplate
    }


    @Bean
    fun retryTemplate() : RetryTemplate{

        val retryPolicy = AlwaysRetryPolicy()
        val backOffPolicy = ExponentialBackOffPolicy()


        val template = RetryTemplate()
        template.registerListener(object : RetryListenerSupport(){
                override fun <T : Any?, E : Throwable?> onError(
                context: RetryContext?,
                callback: RetryCallback<T, E>?,
                throwable: Throwable?

            ) {
                    println(throwable.toString())
            }
        })
        template.setRetryPolicy(retryPolicy)
        template.setBackOffPolicy(backOffPolicy)

        return template


    }

    @Bean
    fun gson(): Gson = GsonBuilder()
        .setPrettyPrinting()
        .disableHtmlEscaping()
        .create()


}