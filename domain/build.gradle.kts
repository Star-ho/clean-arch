import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// 루트 모듈에서 plugin 버전지정 하위모듈에선 버전지정 X

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:2.6.5")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.5")
    implementation("org.springframework.boot:spring-boot-starter-jdbc:2.6.5")
    implementation("org.springframework.boot:spring-boot-starter-web:2.6.5")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.1.210")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    runtimeOnly("com.h2database:h2:2.1.210")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.5")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
