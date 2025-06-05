package com.rif.glorygames.core.domain.usecase

import com.rif.glorygames.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameUseCase {
    fun getAllGame(): Flow<com.rif.glorygames.core.data.Resource<List<Game>>>
    fun getFavoriteGame(): Flow<List<Game>>
    fun setFavoriteGame(game: Game, state: Boolean)
}