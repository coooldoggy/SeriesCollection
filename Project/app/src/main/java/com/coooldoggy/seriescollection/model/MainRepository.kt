package com.coooldoggy.seriescollection.model

import com.coooldoggy.seriescollection.model.api.ApiHelper
import com.coooldoggy.seriescollection.model.data.Series
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Response
import javax.inject.Inject

@ViewModelScoped
class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun browseSeries(page: Int) = apiHelper.browse(page = page)
    suspend fun getSeries(id: Int) = apiHelper.getSeries(id)
    suspend fun getEpisodes(id: Int) = apiHelper.getEpisodes(id)
}