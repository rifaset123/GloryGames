package com.rif.glorygames.detail

import androidx.lifecycle.ViewModel
import com.rif.glorygames.core.domain.model.Game
import com.rif.glorygames.core.domain.usecase.GameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailGameViewModel @Inject constructor(private val gameUseCase: GameUseCase) : ViewModel() {
    fun setFavoriteTourism(game: Game, newStatus:Boolean) =
        gameUseCase.setFavoriteTourism(game, newStatus)
}

