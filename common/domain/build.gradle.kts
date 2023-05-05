plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies{
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.kotest:kotest-runner-junit5:${rootProject.extra.get("kotest-version")}")
    testImplementation("io.kotest:kotest-assertions-core:${rootProject.extra.get("kotest-version")}")
    testImplementation("com.ninja-squad:springmockk:${rootProject.extra.get("springmockk-version")}")
}

val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = false
jar.enabled = true