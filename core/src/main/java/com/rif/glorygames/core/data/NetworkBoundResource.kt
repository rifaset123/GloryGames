package com.rif.glorygames.core.data

import com.rif.glorygames.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType, RequestType> {

    private var result: Flow<com.rif.glorygames.core.data.Resource<ResultType>> = flow {
        emit(com.rif.glorygames.core.data.Resource.Loading())
        val dbSource = loadFromDB().first()
        if (shouldFetch(dbSource)) {
            emit(com.rif.glorygames.core.data.Resource.Loading())
            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    saveCallResult(apiResponse.data)
                    emitAll(loadFromDB().map {
                        com.rif.glorygames.core.data.Resource.Success(
                            it
                        )
                    })
                }
                is ApiResponse.Empty -> {
                    emitAll(loadFromDB().map { com.rif.glorygames.core.data.Resource.Success(it) })
                }
                is ApiResponse.Error -> {
                    onFetchFailed()
                    emit(com.rif.glorygames.core.data.Resource.Error(apiResponse.errorMessage))
                }
            }
        } else {
            emitAll(loadFromDB().map { com.rif.glorygames.core.data.Resource.Success(it) })
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<com.rif.glorygames.core.data.Resource<ResultType>> = result
}