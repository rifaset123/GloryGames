package com.rif.glorygames.core.domain.usecase

import com.rif.glorygames.core.domain.model.Game
import com.rif.glorygames.core.domain.repository.IGameRepository
import javax.inject.Inject

class GameInteractor @Inject constructor (private val tourismRepository: IGameRepository): GameUseCase {

    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(game: Game, state: Boolean) = tourismRepository.setFavoriteTourism(game, state)
}