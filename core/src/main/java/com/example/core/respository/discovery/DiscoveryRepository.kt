package com.example.core.respository.discovery

import androidx.lifecycle.LiveData
import com.example.core.api.MovieDatabaseAPIService
import com.example.core.data.database.GuacamoleDatabase
import com.example.core.data.database.model.Content
import com.example.core.data.mapper.ContentMapper
import com.example.core.data.network.ContentResult
import com.example.core.result.Resource
import com.example.core.util.network.NetworkBoundResource
import com.example.core.util.rx.SchedulerProvider
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy


/**
 * Class used to provide data to the Discovery Fragment
 * * Repository abstracts the logic of fetching the data and persisting it for
 * offline. They are the data source as the single source of truth.
 */
class DiscoveryRepositoryImpl(
        private val guacamoleDatabase: GuacamoleDatabase,
        private val movieDatabaseAPIService: MovieDatabaseAPIService,
        private val contentMapper: ContentMapper,
        private val schedulerProvider: SchedulerProvider
) : DiscoveryRepository {

    override fun fetchListOfMovies(): LiveData<Resource<List<Content>>> {

        return object : NetworkBoundResource<List<Content>, ContentResult>(schedulerProvider) {

            override fun processResponse(response: ContentResult): List<Content> {

                val list = mutableListOf<Content>()
                response.results.forEach {
                    list.add(contentMapper.convertToDbContent(it))
                }
                return list
            }

            override fun saveCallResult(item: List<Content>) = guacamoleDatabase.contentDao().setAll(item)

            override fun shouldFetch(data: List<Content>): Boolean = true

            override fun loadFromDb(): LiveData<List<Content>> {
                return guacamoleDatabase.contentDao().getAll()
            }

            override fun createCall(): Single<ContentResult> = movieDatabaseAPIService.discoverContent(emptyMap())

        }.asLiveData()

    }
}