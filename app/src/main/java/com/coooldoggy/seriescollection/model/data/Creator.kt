package com.coooldoggy.seriescollection.model.data

import com.google.gson.annotations.SerializedName

data class Creator(
    @SerializedName("id")
    val id: Int,

    @SerializedName("uname")
    val uname: String,

    @SerializedName("display_name")
    val displayName: String,

    @SerializedName("profile_pic_url")
    val profilePicUrl: String,

    @SerializedName("joined_creator_tips")
    val joinedCreatorTips: Boolean
)
