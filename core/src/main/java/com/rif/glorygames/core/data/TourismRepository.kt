package com.rif.glorygames.core.data

import com.rif.glorygames.core.data.source.local.LocalDataSource
import com.rif.glorygames.core.data.source.remote.RemoteDataSource
import com.rif.glorygames.core.data.source.remote.network.ApiResponse
import com.rif.glorygames.core.data.source.remote.response.TourismResponse
import com.rif.glorygames.core.domain.model.Tourism
import com.rif.glorygames.core.domain.repository.ITourismRepository
import com.rif.glorygames.core.utils.AppExecutors
import com.rif.glorygames.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TourismRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITourismRepository {

    override fun getAllTourism(): Flow<com.rif.glorygames.core.data.Resource<List<Tourism>>> =
        object : com.rif.glorygames.core.data.NetworkBoundResource<List<Tourism>, List<TourismResponse>>() {
            override fun loadFromDB(): Flow<List<Tourism>> {
                return localDataSource.getAllTourism().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Tourism>?): Boolean =
                data.isNullOrEmpty() // mengambil data dari internet hanya jika data di database kosong
//                 true // ganti dengan true jika ingin selalu mengambil data dari internet

            override suspend fun createCall(): Flow<ApiResponse<List<TourismResponse>>> =
                remoteDataSource.getAllTourism()

            override suspend fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asFlow()

    override fun getFavoriteTourism(): Flow<List<Tourism>> {
        return localDataSource.getFavoriteTourism().map {
           DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }
}

