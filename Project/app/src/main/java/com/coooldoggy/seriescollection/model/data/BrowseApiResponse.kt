package com.coooldoggy.seriescollection.model.data

import com.google.gson.annotations.SerializedName

data class BrowseApiResponse(
    @SerializedName("pagination")
    val pagination: Pagination,

    @SerializedName("series")
    val series: ArrayList<Series>
)

data class Pagination(
    @SerializedName("page")
    val page: Int,

    @SerializedName("has_next")
    val hasNext: Boolean
)
