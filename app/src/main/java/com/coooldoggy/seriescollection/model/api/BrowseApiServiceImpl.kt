package com.coooldoggy.seriescollection.model.api

import javax.inject.Inject

class BrowseApiServiceImpl @Inject constructor(private val browseApiService: BrowseApiService) : BrowseApiHelper{
    override suspend fun browse(type: String, page: Int) = browseApiService.browse(type, page)
}