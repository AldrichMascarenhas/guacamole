package com.example.guacamole.di.viewmodels

import com.example.guacamole.discoverfragment.DiscoveryViewModel
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModules = module {

    viewModel { DiscoveryViewModel(discoveryRepository = get()) }
}