plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion (28)


    defaultConfig {
        applicationId = "com.example.guacamole"
        minSdkVersion (21)
        targetSdkVersion (28)
        versionCode = 1
        versionName =  "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")
        }
    }

}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.11")

    implementation ("androidx.leanback:leanback:1.0.0")

    implementation("androidx.appcompat:appcompat:1.0.2")

    implementation ("com.github.bumptech.glide:glide:3.8.0")
}
