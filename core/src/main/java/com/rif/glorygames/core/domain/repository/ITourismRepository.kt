package com.rif.glorygames.core.domain.repository

import com.rif.glorygames.core.data.Resource
import com.rif.glorygames.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {

    fun getAllTourism(): Flow<com.rif.glorygames.core.data.Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}
