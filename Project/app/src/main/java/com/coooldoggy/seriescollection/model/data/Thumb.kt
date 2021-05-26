package com.coooldoggy.seriescollection.model.data

import com.google.gson.annotations.SerializedName

data class Thumb(
    @SerializedName("width")
    val width: Int,

    @SerializedName("height")
    val height: Int,

    @SerializedName("file_size")
    val fileSize: Int,

    @SerializedName("file_url")
    val fileUrl: Int
)