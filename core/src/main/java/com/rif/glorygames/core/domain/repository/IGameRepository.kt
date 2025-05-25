package com.rif.glorygames.core.domain.repository

import com.rif.glorygames.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface IGameRepository {

    fun getAllGames(): Flow<com.rif.glorygames.core.data.Resource<List<Game>>>

    fun getFavoriteGames(): Flow<List<Game>>

    fun setFavoriteGames(game: Game, state: Boolean)
}
