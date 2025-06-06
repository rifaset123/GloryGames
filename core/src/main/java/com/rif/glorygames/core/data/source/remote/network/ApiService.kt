package com.rif.glorygames.core.data.source.remote.network

import com.rif.glorygames.core.data.source.remote.response.ListGameResponse
import retrofit2.http.GET

interface ApiService {
    @GET("games")
    suspend fun getList(@retrofit2.http.Query("page_size") pageSize: Int): ListGameResponse
}
