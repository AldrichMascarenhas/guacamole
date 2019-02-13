package com.example.core.api

import com.example.core.data.network.ContentResult
import com.example.core.result.Resource
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface MovieDatabaseAPIService {

    @GET("discover/movie")
    fun discoverContent(@QueryMap options: Map<String, String>): Single<ContentResult>
}
