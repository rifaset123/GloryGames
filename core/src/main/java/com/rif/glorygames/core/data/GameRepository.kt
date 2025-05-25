package com.rif.glorygames.core.data

import com.rif.glorygames.core.data.source.local.LocalDataSource
import com.rif.glorygames.core.data.source.remote.RemoteDataSource
import com.rif.glorygames.core.data.source.remote.network.ApiResponse
import com.rif.glorygames.core.data.source.remote.response.GameResponse
import com.rif.glorygames.core.domain.model.Game
import com.rif.glorygames.core.domain.repository.IGameRepository
import com.rif.glorygames.core.utils.AppExecutors
import com.rif.glorygames.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IGameRepository {

    override fun getAllGames(): Flow<Resource<List<Game>>> =
        object : NetworkBoundResource<List<Game>, List<GameResponse>>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getAllGame().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Game>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponse>>> =
                remoteDataSource.getAllTourism()

            override suspend fun saveCallResult(data: List<GameResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertGame(tourismList)
            }
        }.asFlow()

    override fun getFavoriteGames(): Flow<List<Game>> {
        return localDataSource.getFavoriteGame().map {
           DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteGames(game: Game, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(game)
        appExecutors.diskIO().execute { localDataSource.setFavoriteGame(tourismEntity, state) }
    }
}

