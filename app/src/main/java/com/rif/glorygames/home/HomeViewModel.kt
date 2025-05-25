package com.rif.glorygames.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rif.glorygames.core.domain.usecase.GameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(gameUseCase: GameUseCase) : ViewModel() {
    val tourism = gameUseCase.getAllGame().asLiveData()
}

