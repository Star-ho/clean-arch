plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

dependencies {
    implementation(project(":product:domain"))
    implementation(project(":product:data"))
    implementation(project(":member:domain"))
    implementation(project(":member:data"))
    implementation(project(":order:domain"))
    implementation(project(":order:data"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")

    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springdoc:springdoc-openapi-data-rest:1.6.6")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.6")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.6.6")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.kotest:kotest-runner-junit5:${rootProject.extra.get("kotest-version")}")
    testImplementation("io.kotest:kotest-assertions-core:${rootProject.extra.get("kotest-version")}")
    testImplementation("com.ninja-squad:springmockk:${rootProject.extra.get("springmockk-version")}")
}


val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = true
//
bootJar.duplicatesStrategy = org.gradle.api.file.DuplicatesStrategy.INCLUDE
jar.enabled = true