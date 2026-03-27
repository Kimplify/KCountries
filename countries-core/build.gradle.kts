import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.maven.publish)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "CountriesCore"
            isStatic = true
        }
    }

    jvm()

    js {
        browser()
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        androidMain.dependencies {

        }
        commonMain.dependencies {
            implementation(libs.kotlin.codepoints)
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
        jvmMain.dependencies {

        }
    }
}

val generateVersionFile = tasks.register("generateVersionFile") {
    val version = libs.versions.kcountries.get()
    val outputDir = layout.buildDirectory.dir("generated/version/kotlin")
    outputs.dir(outputDir)
    doLast {
        val dir = outputDir.get().asFile.resolve("org/kimplify/countries")
        dir.mkdirs()
        dir.resolve("BuildKConfig.kt").writeText(
            """
            |package org.kimplify.countries
            |
            |internal object BuildKConfig {
            |    const val VERSION = "$version"
            |}
            """.trimMargin()
        )
    }
}

kotlin.sourceSets.commonMain {
    kotlin.srcDir(generateVersionFile.map { it.outputs.files.singleFile })
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask<*>>().configureEach {
    dependsOn(generateVersionFile)
}

android {
    namespace = "org.kimplify.countriesCore"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

//Publishing your Kotlin Multiplatform library to Maven Central
//https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-publish-libraries.html
mavenPublishing {
    publishToMavenCentral()
    signAllPublications()
    coordinates("org.kimplify", "countries-core", libs.versions.kcountries.get())

    pom {
        name = "KCountries"
        description = "Kotlin Multiplatform library providing ISO 3166-1 country codes, names and flag emojis."
        url = "https://github.com/Kimplify/KCountries"

        licenses {
            license {
                name = "MIT License"
                url = "https://opensource.org/licenses/MIT"
            }
        }

        developers {
            developer {
                id = "merkost"
                name = "Konstantin Merenkov"
                email = "kosta0212@gmail.com"
            }

            developer {
                id = "diogocavaiar"
                name = "Diogo Cavaiar"
                email = "cavaiarconsulting@gmail.com"
            }
        }

        scm {
            connection = "scm:git:https://github.com/Kimplify/KCountries"
            developerConnection = "scm:git:ssh://git@github.com/Kimplify/KCountries.git"
            url = "https://github.com/Kimplify/KCountries"
        }
    }
}
