import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose)
    alias(libs.plugins.android.application)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                    freeCompilerArgs.add("-Xjdk-release=${JavaVersion.VERSION_1_8}")
                }
            }
        }
        //https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-test.html
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        instrumentedTestVariant {
            sourceSetTree.set(KotlinSourceSetTree.test)
//            dependencies {
//                debugImplementation(libs.androidx.testManifest)
//                implementation(libs.androidx.junit4)
//            }
        }
    }


    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.cmptoast)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.uiTest)
        }

        androidMain.dependencies {
            implementation(compose.uiTooling)
            implementation(libs.androidx.activityCompose)
        }

    }
}

android {
    namespace = "network.chaintech.cmptoastdemo"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        targetSdk = 34

        applicationId = "network.chaintech.cmptoastdemo.androidApp"
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/res")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
}

//https://developer.android.com/develop/ui/compose/testing#setup
dependencies {
    androidTestImplementation(libs.androidx.uitest.junit4)
    debugImplementation(libs.androidx.uitest.testManifest)
    //temporary fix: https://youtrack.jetbrains.com/issue/CMP-5864
    androidTestImplementation("androidx.test:monitor") {
        version { strictly("1.6.1") }
    }
}
