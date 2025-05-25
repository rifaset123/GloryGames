package com.rif.glorygames.di

import com.rif.glorygames.core.domain.usecase.GameInteractor
import com.rif.glorygames.core.domain.usecase.GameUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideTourismUseCase(gameInteractor: GameInteractor): GameUseCase

}
