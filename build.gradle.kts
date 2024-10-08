plugins {
    id("java")
    id("io.qameta.allure") version "2.12.0"
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
    testImplementation("org.assertj:assertj-core:3.26.3")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")

}

tasks.test {
    useJUnitPlatform()
}
