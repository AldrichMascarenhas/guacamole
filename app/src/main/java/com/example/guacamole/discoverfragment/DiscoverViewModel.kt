package com.example.guacamole.discoverfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel;
import com.example.core.data.database.model.Content
import com.example.core.respository.discovery.DiscoveryRepository
import com.example.core.result.Resource
import org.koin.standalone.KoinComponent

class DiscoveryViewModel(
    private val discoveryRepository: DiscoveryRepository
) : ViewModel(), KoinComponent {

    private val _listOfMovies = MediatorLiveData<List<Content>>()

     val listOfMoives : LiveData<List<Content>>
        get() = _listOfMovies

    // TODO: Implement the ViewModel correctly
    fun getData() = discoveryRepository.fetchListOfMovies()

}
