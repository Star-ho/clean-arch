plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":domain:order"))
    implementation(project(":usecase:member"))
    implementation(project(":usecase:product"))
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:2.6.5")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.5")
    implementation("org.springframework.boot:spring-boot-starter-jdbc:2.6.5")
    implementation("org.springframework.boot:spring-boot-starter-web:2.6.5")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.1.210")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.5")
}