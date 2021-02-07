import org.gradle.api.JavaVersion.VERSION_15

plugins {
    java
}

group = "com.priyakdey"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = VERSION_15
java.targetCompatibility = VERSION_15

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.7.1")
    testImplementation("org.junit.jupiter", "junit-jupiter-engine", "5.7.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
