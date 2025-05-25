package com.rif.glorygames.di

import com.rif.glorygames.core.domain.usecase.GameInteractor
import com.rif.glorygames.core.domain.usecase.GameUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideGameUseCase(gameInteractor: GameInteractor): GameUseCase
}
