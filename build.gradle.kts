// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0-beta01")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.20")
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}