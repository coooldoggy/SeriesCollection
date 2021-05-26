package com.coooldoggy.seriescollection.model.api

import javax.inject.Inject

class BrowseApiServiceImpl @Inject constructor(private val browseApiService: BrowseApiService) : BrowseApiHelper{
    override suspend fun browse(page: Int) = browseApiService.browse(page = page)
}