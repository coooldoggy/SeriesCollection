package com.coooldoggy.seriescollection.model.data

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("abbr")
    val abbr: String,

    @SerializedName("books")
    val books: Boolean
)