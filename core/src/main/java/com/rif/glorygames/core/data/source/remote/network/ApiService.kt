package com.rif.glorygames.core.data.source.remote.network

import com.rif.glorygames.core.data.source.remote.response.ListTourismResponse
import retrofit2.http.GET

interface ApiService {
    @GET("list")
    suspend fun getList(): ListTourismResponse
}
