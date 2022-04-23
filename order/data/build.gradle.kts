plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common:data"))
    implementation(project(":member:data"))
    implementation(project(":product:data"))
    implementation(project(":order:usecase"))
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:2.6.5")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.5")
    implementation("org.springframework.boot:spring-boot-starter-jdbc:2.6.5")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.2")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.5")
    implementation("mysql:mysql-connector-java:8.0.28")
}