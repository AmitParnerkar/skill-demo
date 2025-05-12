
plugins {
    kotlin("jvm") version "1.9.25" apply false
    id("org.springframework.boot") version "3.4.2" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
}

allprojects {
    group = "com.target"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}
    