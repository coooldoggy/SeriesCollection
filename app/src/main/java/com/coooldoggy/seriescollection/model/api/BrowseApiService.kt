package com.coooldoggy.seriescollection.model.api

import com.coooldoggy.seriescollection.BROWSE_SUB_URL
import com.coooldoggy.seriescollection.model.data.BrowseApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BrowseApiService {

    @GET(BROWSE_SUB_URL)
    suspend fun browse(@Query("series_type")type: String, @Query("page")page: Int = 1): Response<BrowseApiResponse>
}