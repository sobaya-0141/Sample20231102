import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.skiePlugin)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktorfitPlugin)
}

kotlin {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    targetHierarchy.default()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.skie)
                implementation(libs.kotlinx.coroutines.core)
            }
        }
        val commonTest by getting {
            dependencies {
            }
        }
        val iosMain by getting {
            dependencies {
            }
        }
    }
}

dependencies {
    add("kspCommonMainMetadata", libs.ktorfitKsp)
    // add("kspJvm", libs.ktorfitKsp)
    // add("kspAndroid", libs.ktorfitKsp)
    add("kspIosX64", libs.ktorfitKsp)
    add("kspIosSimulatorArm64", libs.ktorfitKsp)
}
