package com.coooldoggy.seriescollection.model.data

import com.google.gson.annotations.SerializedName

data class Episode(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("scene")
    val scene: Int,

    @SerializedName("free")
    val free: Boolean,

    @SerializedName("downloadable")
    val downloadable: Boolean,

    @SerializedName("thumb")
    val thumb: Thumb,

    @SerializedName("created_date")
    val createdDate: String,

    @SerializedName("nsfw")
    val nsfw: Boolean,

    @SerializedName("read")
    val read: Boolean,

    @SerializedName("unlocked")
    val unlocked: Boolean,

    @SerializedName("nu")
    val nu: Boolean,

    @SerializedName("early_access")
    val earlyAccess: Boolean,

    @SerializedName("support_supporting_ad")
    val supportSupportingAd: Boolean,

    @SerializedName("view_cnt")
    val viewCnt: Int,

    @SerializedName("scheduled_date")
    val scheduledDate: String

)
