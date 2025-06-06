package com.rif.glorygames.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rif.glorygames.core.domain.usecase.GameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(gameUseCase: GameUseCase) : ViewModel() {
    val favoriteTourism = gameUseCase.getFavoriteTourism().asLiveData()
}