import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.40"
    id("io.gitlab.arturbosch.detekt").version("1.0.0-RC15")
}

group = "com.schehata"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven(url="https://dl.bintray.com/arrow-kt/arrow-kt/")
    maven(url="https://oss.jfrog.org/artifactory/oss-snapshot-local/")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}


tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform { }
}

val arrowVersion = "0.9.0-SNAPSHOT"

dependencies {
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.3.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.2.3")
    implementation("io.arrow-kt:arrow-core-data:$arrowVersion")

    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.2")
}

detekt {
    toolVersion = "1.0.0.RC9.2"
    input = files("src/main/kotlin", "src/test/kotlin")
    filters = ".*/resources/.*,.*/build/.*"
}