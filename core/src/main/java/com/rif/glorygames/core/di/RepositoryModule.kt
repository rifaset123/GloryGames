package com.rif.glorygames.core.di

import com.rif.glorygames.core.data.GameRepository
import com.rif.glorygames.core.data.source.local.LocalDataSource
import com.rif.glorygames.core.data.source.remote.RemoteDataSource
import com.rif.glorygames.core.domain.repository.IGameRepository
import com.rif.glorygames.core.utils.AppExecutors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        remote: RemoteDataSource,
        local: LocalDataSource,
        executors: AppExecutors
    ): IGameRepository =
        GameRepository(remote, local, executors)

}