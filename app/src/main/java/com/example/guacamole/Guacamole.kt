package com.example.guacamole

import android.app.Application
import com.example.core.di.coreDIModules
import com.example.core.di.remoteDataSourceDIModule
import org.koin.android.ext.android.startKoin

class Guacamole : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(coreDIModules, remoteDataSourceDIModule))


    }
}
