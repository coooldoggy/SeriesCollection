package com.coooldoggy.seriescollection.model

import com.coooldoggy.seriescollection.model.api.BrowseApiHelper
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class SeriesRepository @Inject constructor(private val apiHelper: BrowseApiHelper) {
    suspend fun browseSeries(page: Int) = apiHelper.browse(page = page)
}