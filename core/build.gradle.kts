
plugins{
    id("com.android.library")
}

android {
    compileSdkVersion (28)


    defaultConfig {
        minSdkVersion (21)
        targetSdkVersion (28)
        versionCode=  1
        versionName = "1.0"

        testInstrumentationRunner =  "android.support.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled  = false
            proguardFiles("proguard-rules.pro")
        }
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation ("com.android.support:appcompat-v7:28.0.0")
    testImplementation ("junit:junit:4.12")
    androidTestImplementation ("com.android.support.test:runner:1.0.2")
    androidTestImplementation ("com.android.support.test.espresso:espresso-core:3.0.2")


    implementation ("com.squareup.retrofit2:retrofit:2.5.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.5.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.5.0")

    implementation("com.squareup.okhttp3:okhttp:3.12.1")
    implementation ("com.squareup.okhttp3:okhttp:3.12.1")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.12.1")


    // Koin for Kotlin
    api  ("org.koin:koin-core:1.0.0-beta-3")
    // Koin for Android
    api ("org.koin:koin-android:1.0.0-beta-3")

}
