plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.ghosttrio"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("reflect"))
    testImplementation("io.kotest:kotest-runner-junit5:5.4.2") // kotlin junit 처럼 쓸 수 있는 Spec 들이 정의 됨
    testImplementation("io.kotest:kotest-assertions-core:5.4.2") // shouldBe... etc 와같이 Assertions 의 기능을 제공
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}