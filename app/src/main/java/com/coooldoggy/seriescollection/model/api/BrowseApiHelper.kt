package com.coooldoggy.seriescollection.model.api

import com.coooldoggy.seriescollection.model.data.BrowseApiResponse
import retrofit2.Response

interface BrowseApiHelper {
    suspend fun browse(type: String, page: Int): Response<BrowseApiResponse>
}