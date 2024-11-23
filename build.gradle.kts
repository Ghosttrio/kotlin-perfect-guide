plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.ghosttrio"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}