package com.rif.favorite

import com.rif.glorygames.core.domain.repository.IGameRepository
import com.rif.glorygames.core.domain.usecase.GameInteractor
import com.rif.glorygames.core.domain.usecase.GameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoriteModule {
    @Provides
    @Singleton
    fun provideGameUseCase(repository: IGameRepository): GameUseCase =
        GameInteractor(repository) // Provide the GameUseCase implementation using the IGameRepository
}