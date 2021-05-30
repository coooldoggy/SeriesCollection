package com.coooldoggy.seriescollection.model.api

import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) : ApiHelper{
    override suspend fun browse(page: Int) = apiService.browse(page = page)
    override suspend fun getSeries(id: Int) = apiService.getSeries(id)
    override suspend fun getEpisodes(id: Int) = apiService.getEpisodes(id)
}