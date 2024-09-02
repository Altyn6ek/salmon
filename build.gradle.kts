plugins {
    id("java")
    id("io.qameta.allure") version "2.9.3"
}

group = "kz.anyDrop"
version = "1.0"

val allureVersion = "2.25.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("io.rest-assured:rest-assured:5.5.0")
    testImplementation(platform("io.qameta.allure:allure-bom:$allureVersion"))
    testImplementation("io.qameta.allure:allure-rest-assured")

}

tasks.test {
    useJUnitPlatform()
}
