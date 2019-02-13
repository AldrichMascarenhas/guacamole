package com.example.core.respository.discovery

import androidx.lifecycle.LiveData
import com.example.core.data.database.model.Content
import com.example.core.result.Resource


interface DiscoveryRepository {

    fun fetchListOfMovies() : LiveData<Resource<List<Content>>>

}