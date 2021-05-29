package com.coooldoggy.seriescollection.model.api

import com.coooldoggy.seriescollection.BROWSE_SUB_URL
import com.coooldoggy.seriescollection.EPISODE_SUB_URL
import com.coooldoggy.seriescollection.SERIES_SUB_URL
import com.coooldoggy.seriescollection.SERIES_TYPE
import com.coooldoggy.seriescollection.model.data.BrowseApiResponse
import com.coooldoggy.seriescollection.model.data.Episode
import com.coooldoggy.seriescollection.model.data.Series
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(BROWSE_SUB_URL)
    suspend fun browse(@Query("series_type")type: String = SERIES_TYPE, @Query("page")page: Int = 1):
            Response<BrowseApiResponse>

    @GET(SERIES_SUB_URL)
    suspend fun getSeries(@Query("series_id") id: Int): Response<Series>

    @GET(EPISODE_SUB_URL)
    suspend fun getEpisodes(@Path("series_id") id: Int): Response<ArrayList<Episode>>
}