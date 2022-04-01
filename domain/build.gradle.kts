import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

//plugins {
//    id("org.springframework.boot") version "2.6.5"
//    id("io.spring.dependency-management") version "1.0.11.RELEASE"
//    kotlin("jvm") version "1.6.10"
//    kotlin("plugin.spring") version "1.6.10"
//    kotlin("plugin.jpa") version "1.6.10"
//    id("java")
//}

group = "com.example"
version = "0.0.1-SNAPSHOT"
//java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
//    implementation(project(":library"))
//    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.springframework.boot:spring-boot-starter-jdbc")
//    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    runtimeOnly("com.h2database:h2")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

//bootJar {
//    enabled = false
//}
//
//jar {
//    enabled = true
//}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
