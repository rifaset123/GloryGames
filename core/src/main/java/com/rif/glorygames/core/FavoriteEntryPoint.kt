package com.rif.glorygames.core

import com.rif.glorygames.core.domain.usecase.GameUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteEntryPoint {
    fun gameUseCase(): GameUseCase // so it can be used in the Favorite feature module
}
