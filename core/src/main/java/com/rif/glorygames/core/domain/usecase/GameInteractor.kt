package com.rif.glorygames.core.domain.usecase

import com.rif.glorygames.core.domain.model.Game
import com.rif.glorygames.core.domain.repository.IGameRepository
import javax.inject.Inject

class GameInteractor @Inject constructor (private val tourismRepository: IGameRepository): GameUseCase {

    override fun getAllTourism() = tourismRepository.getAllGames()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteGames()

    override fun setFavoriteTourism(game: Game, state: Boolean) = tourismRepository.setFavoriteGames(game, state)
}