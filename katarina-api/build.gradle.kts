import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.spring") version "1.4.21"
    kotlin("plugin.jpa") version  "1.4.21"
}

group = "com.hubtwork"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // libs for RestTemplate
    implementation("org.springframework:spring-web")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")

    // libs for WebClient
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // libs for Junit
    implementation("junit:junit:4.12")
    implementation("junit:junit:4.12")
    implementation("org.junit.jupiter:junit-jupiter:5.4.2")


    implementation("org.springframework.retry:spring-retry")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")

    implementation("mysql:mysql-connector-java")


}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

