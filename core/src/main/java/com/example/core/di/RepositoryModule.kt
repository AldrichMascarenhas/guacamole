package com.example.core.di

import com.example.core.respository.discovery.DiscoveryRepository
import com.example.core.respository.discovery.DiscoveryRepositoryImpl
import org.koin.dsl.module.module

val repositoryModule = module {


    single<DiscoveryRepository> {
        DiscoveryRepositoryImpl(
            guacamoleDatabase = get(),
            movieDatabaseAPIService = get(),
            contentMapper = get(),
            schedulerProvider = get()
        )
    }

}