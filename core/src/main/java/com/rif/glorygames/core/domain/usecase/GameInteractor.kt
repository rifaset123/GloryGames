package com.rif.glorygames.core.domain.usecase

import com.rif.glorygames.core.domain.model.Game
import com.rif.glorygames.core.domain.repository.IGameRepository
import javax.inject.Inject

class GameInteractor @Inject constructor (private val gameRepository: IGameRepository): GameUseCase {

    override fun getAllGame() = gameRepository.getAllGames()

    override fun getFavoriteGame() = gameRepository.getFavoriteGames()

    override fun setFavoriteGame(game: Game, state: Boolean) = gameRepository.setFavoriteGames(game, state)
}