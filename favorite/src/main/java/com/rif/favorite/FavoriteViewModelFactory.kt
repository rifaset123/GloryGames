package com.rif.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rif.glorygames.core.domain.usecase.GameUseCase

// Factory class to create instances of FavoriteViewModel
class FavoriteViewModelFactory(
    private val gameUseCase: GameUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoriteViewModel(gameUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}