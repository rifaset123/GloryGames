package com.rif.glorygames.core.domain.repository

import com.rif.glorygames.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface IGameRepository {

    fun getAllTourism(): Flow<com.rif.glorygames.core.data.Resource<List<Game>>>

    fun getFavoriteTourism(): Flow<List<Game>>

    fun setFavoriteTourism(game: Game, state: Boolean)
}
