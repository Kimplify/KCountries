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
            baseName = "CountriesI18n"
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
            implementation(project(":countries-core"))
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
        jvmMain.dependencies {

        }
    }
}

android {
    namespace = "org.kimplify.countriesI18n"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
    }
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()
    coordinates("org.kimplify", "countries-i18n", libs.versions.kcountries.get())

    pom {
        name = "KCountries I18n"
        description = "Internationalization module for KCountries library providing country name translations in multiple languages."
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