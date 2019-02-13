package com.example.guacamole

import android.app.Application
import com.example.core.di.coreDIModules
import com.example.core.di.mapperModule
import com.example.core.di.remoteDataSourceDIModule
import com.example.core.di.repositoryModule
import com.example.guacamole.di.viewmodels.viewModelModules
import org.koin.android.ext.android.startKoin

class Guacamole : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(
            this,
            listOf(coreDIModules, remoteDataSourceDIModule, repositoryModule, mapperModule, viewModelModules),
            loadPropertiesFromFile = true
        )


    }
}
