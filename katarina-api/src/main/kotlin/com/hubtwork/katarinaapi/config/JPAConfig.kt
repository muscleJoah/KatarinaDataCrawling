package com.hubtwork.katarina.batchmatch.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManagerFactory",
    transactionManagerRef = "transactionManager",
    basePackages = ["com.hubtwork.katarinaapi.jpa"]
)
class JPAConfig {
    @Primary
    @Bean
    fun entityManagerFactory(
        datasource: DataSource,
        builder: EntityManagerFactoryBuilder
    ): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(datasource)
            .packages("com.hubtwork.katarinaapi.jpa")
            .persistenceUnit("katarina")
            .build()
    }

    @Primary
    @Bean
    fun transactionManager(entityManagerFactory: LocalContainerEntityManagerFactoryBean): JpaTransactionManager {
        return JpaTransactionManager(entityManagerFactory.`object`!!)
    }
}