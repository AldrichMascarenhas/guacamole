package com.example.core.api.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val url =
            chain.request().url().newBuilder().addQueryParameter("api_key", "38aaefc6680b859538621110d40543a5").build()
        val request = chain.request().newBuilder().url(url).build()

        return chain.proceed(request)
    }
}