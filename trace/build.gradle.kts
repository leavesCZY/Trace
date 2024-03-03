@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.gradle.plugin.publish)
    id("java-library")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    withJavadocJar()
    withSourcesJar()
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

group = "io.github.leavesczy"
version = "1.1.0"

gradlePlugin {
    website.set("https://github.com/leavesCZY/Trace")
    vcsUrl.set("https://github.com/leavesCZY/Trace.git")
    plugins {
        create("TracePlugin") {
            id = "${group}.trace"
            implementationClass = "github.leavesczy.trace.TracePlugin"
            displayName = "Android Developer ASM Gradle Plugin"
            description = "Android Developer ASM Gradle Plugin"
            tags.set(setOf("agp", "asm"))
        }
    }
}

dependencies {
    compileOnly(libs.android.gradle)
    compileOnly(libs.android.gradle.api)
    compileOnly(libs.ow2.asm.commons)
}