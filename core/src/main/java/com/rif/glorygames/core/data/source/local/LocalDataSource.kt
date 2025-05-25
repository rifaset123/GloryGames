package com.rif.glorygames.core.data.source.local

import com.rif.glorygames.core.data.source.local.entity.GameEntity
import com.rif.glorygames.core.data.source.local.room.GameDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val gameDao: GameDao) {

    fun getAllTourism(): Flow<List<GameEntity>> = gameDao.getAllTourism()

    fun getFavoriteTourism(): Flow<List<GameEntity>> = gameDao.getFavoriteTourism()

    suspend fun insertTourism(tourismList: List<GameEntity>) = gameDao.insertTourism(tourismList)

    fun setFavoriteTourism(tourism: GameEntity, newState: Boolean) {
        tourism.isFavorite = newState
        gameDao.updateFavoriteTourism(tourism)
    }
}