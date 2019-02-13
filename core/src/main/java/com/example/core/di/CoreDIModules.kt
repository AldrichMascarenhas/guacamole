package com.example.core.di

import com.example.core.util.rx.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module.module

val coreDIModules = module {

    // Both return Scheduler type
    single("IO_SCHEDULER") { Schedulers.io() }
    single("MAIN_THREAD_SCHEDULER") { AndroidSchedulers.mainThread() }

    single { SchedulerProvider(backgroundScheduler = get("IO_SCHEDULER"),foregroundScheduler =  get("MAIN_THREAD_SCHEDULER")) }

}
