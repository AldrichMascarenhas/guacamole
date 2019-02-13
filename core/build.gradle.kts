plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(28)


    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

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

    //Kotlin Standard Library JDK 7 extension
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.11")

    //Networking
    implementation("com.squareup.retrofit2:retrofit:2.5.0")
    implementation("com.squareup.retrofit2:converter-gson:2.5.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.5.0")
    implementation("com.squareup.okhttp3:okhttp:3.12.1")
    implementation("com.squareup.okhttp3:okhttp:3.12.1")
    implementation("com.squareup.okhttp3:logging-interceptor:3.12.1")
    testImplementation("com.squareup.okhttp3:mockwebserver:3.13.1")

    //Chuck logger
    implementation("com.readystatesoftware.chuck:library:1.1.0")

    //Rx
    implementation("io.reactivex.rxjava2:rxandroid:2.1.0")
    implementation("io.reactivex.rxjava2:rxkotlin:2.3.0")

    //Koin
    api("org.koin:koin-core:1.0.2")
    api("org.koin:koin-android:1.0.2")
    api ("org.koin:koin-android-viewmodel:1.0.2")
    api("org.koin:koin-androidx-scope:1.0.1")
    testImplementation ("org.koin:koin-test:1.0.2")

    // Architecture Components
    api ("androidx.lifecycle:lifecycle-extensions:2.0.0")
    api ("androidx.lifecycle:lifecycle-livedata:2.0.0")
    api ("androidx.lifecycle:lifecycle-viewmodel:2.0.0")

    //Room
    implementation ("androidx.room:room-runtime:2.1.0-alpha04")
    implementation ("androidx.room:room-rxjava2:2.1.0-alpha04")
    kapt ("androidx.room:room-compiler:2.1.0-alpha04")
    testImplementation ("androidx.room:room-testing:2.1.0-alpha04")

    //Mapstruct
    implementation("org.mapstruct:mapstruct:1.3.0.Beta2")
    kapt("org.mapstruct:mapstruct-processor:1.3.0.Beta2")

    //Test
    testImplementation("junit:junit:4.12")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("org.mockito:mockito-core:2.22.0")
    androidTestImplementation("org.mockito:mockito-android:2.22.0")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")

}
