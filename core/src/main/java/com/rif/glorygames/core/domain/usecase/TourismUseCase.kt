package com.rif.glorygames.core.domain.usecase

import com.rif.glorygames.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {
    fun getAllTourism(): Flow<com.rif.glorygames.core.data.Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}