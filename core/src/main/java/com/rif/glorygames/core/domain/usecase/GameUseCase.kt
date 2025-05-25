package com.rif.glorygames.core.domain.usecase

import com.rif.glorygames.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameUseCase {
    fun getAllTourism(): Flow<com.rif.glorygames.core.data.Resource<List<Game>>>
    fun getFavoriteTourism(): Flow<List<Game>>
    fun setFavoriteTourism(game: Game, state: Boolean)
}