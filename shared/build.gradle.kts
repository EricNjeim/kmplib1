import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinxserialization)
    id("com.vanniktech.maven.publish") version "0.29.0"
}
kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        publishLibraryVariants("release", "debug")
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.ktor.client.serialization)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.example.foolib1"
    compileSdk = 34
    defaultConfig {
        minSdk = 27
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
mavenPublishing {
    coordinates(
        groupId = "io.github.ericnjeim",
        artifactId = "lib-kmp",
        version = "1.0.2"
    )

    // Configure POM metadata for the published artifact
    pom {
        name.set("Kmp Lib 1")
        description.set("Library used to open entities on both Android/iOS.")
        inceptionYear.set("2024")
        url.set("https://github.com/EricNjeim/kmplib1")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        // Specify developers information
        developers {
            developer {
                id.set("ericnjeim")
                name.set("Eric Njeim")
                email.set("eric.njeim@gmail.com")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/EricNjeim/kmplib1.git")
            developerConnection.set("scm:git:ssh://github.com/EricNjeim/kmplib1.git")
            url.set("https://github.com/EricNjeim/kmplib1")
        }
    }

    // Configure publishing to Maven Central
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    // Enable GPG signing for all publications
    signAllPublications()
}

// Ensure all necessary publications are created
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}



