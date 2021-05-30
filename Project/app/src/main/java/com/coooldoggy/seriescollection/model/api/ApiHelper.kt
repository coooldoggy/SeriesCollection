package com.coooldoggy.seriescollection.model.api

import com.coooldoggy.seriescollection.model.data.BrowseApiResponse
import com.coooldoggy.seriescollection.model.data.Episode
import com.coooldoggy.seriescollection.model.data.Series
import retrofit2.Response

interface ApiHelper {
    suspend fun browse(page: Int): Response<BrowseApiResponse>
    suspend fun getSeries(id: Int): Response<Series>
    suspend fun getEpisodes(id: Int): Response<ArrayList<Episode>>
}