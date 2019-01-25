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
    implementation ("com.android.support:leanback-v17:28.0.0")
    implementation ("com.android.support:appcompat-v7:28.0.0")
    implementation ("com.github.bumptech.glide:glide:3.8.0")
}
