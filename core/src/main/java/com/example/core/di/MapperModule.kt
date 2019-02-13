package com.example.core.di

import com.example.core.data.mapper.ContentMapper
import org.koin.dsl.module.module
import org.mapstruct.factory.Mappers

val mapperModule = module {

    factory { Mappers.getMapper(ContentMapper::class.java) }

}