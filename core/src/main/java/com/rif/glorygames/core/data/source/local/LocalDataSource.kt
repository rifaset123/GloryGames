package com.rif.glorygames.core.data.source.local

import com.rif.glorygames.core.data.source.local.entity.GameEntity
import com.rif.glorygames.core.data.source.local.room.GameDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val gameDao: GameDao) {

    fun getAllGame(): Flow<List<GameEntity>> = gameDao.getAllTourism()

    fun getFavoriteGame(): Flow<List<GameEntity>> = gameDao.getFavoriteTourism()

    suspend fun insertGame(tourismList: List<GameEntity>) = gameDao.insertTourism(tourismList)

    fun setFavoriteGame(tourism: GameEntity, newState: Boolean) {
        tourism.isFavorite = newState
        gameDao.updateFavoriteTourism(tourism)
    }
}