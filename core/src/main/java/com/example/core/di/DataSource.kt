package com.example.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.core.api.MovieDatabaseAPIService
import com.example.core.api.interceptor.AuthInterceptor
import com.example.core.data.database.GuacamoleDatabase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val remoteDataSourceDIModule = module {

    single { createAuthInterceptor() }

    /**
     * Create single [OkHttpClient]
     */
    single { createOkHttpClient(authInterceptor = get()) }

    single { createRetrofitService<MovieDatabaseAPIService>(get(), getProperty("MOVIE_DATABASE_API_BASE_URL")) }

    single { createGuacamoleDatabase(androidApplication()) }


}

fun createAuthInterceptor() = AuthInterceptor()


fun createOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(authInterceptor)
        .addInterceptor(httpLoggingInterceptor).build()
}


inline fun <reified T> createRetrofitService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
    return retrofit.create(T::class.java)
}

fun createGuacamoleDatabase(context: Context): GuacamoleDatabase =
    Room.databaseBuilder(context, GuacamoleDatabase::class.java, "guacamole_db").build()
