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
        minSdkVersion (23)
        targetSdkVersion (28)
        versionCode=  1
        versionName  = "1.0"
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
    implementation ("com.google.android.support:wearable:2.4.0")
    implementation ("com.google.android.gms:play-services-wearable:16.0.1")
    implementation ("com.android.support:percent:28.0.0")
    implementation ("com.android.support:support-v4:28.0.0")
    implementation ("com.android.support:recyclerview-v7:28.0.0")
    implementation ("com.android.support:wear:28.0.0")
    compileOnly ("com.google.android.wearable:wearable:2.4.0")
}
