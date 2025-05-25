package com.rif.glorygames.core.data.source.local.room

import androidx.room.*
import com.rif.glorygames.core.data.source.local.entity.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM games")
    fun getAllTourism(): Flow<List<GameEntity>>

    @Query("SELECT * FROM games where isFavorite = 1")
    fun getFavoriteTourism(): Flow<List<GameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourism(tourism: List<GameEntity>)

    @Update
    fun updateFavoriteTourism(tourism: GameEntity)
}
