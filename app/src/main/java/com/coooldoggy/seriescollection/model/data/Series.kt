package com.coooldoggy.seriescollection.model.data

import com.google.gson.annotations.SerializedName

data class Series(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("sale_type")
    val saleType: String,

    @SerializedName("thumb")
    val thumb: Thumb,

    @SerializedName("book_cover_url")
    val bookCoverUrl: String,

    @SerializedName("creators")
    val creators: ArrayList<Creator>,

    @SerializedName("age_rating")
    val ageRating: Int,

    @SerializedName("rgb_hex")
    val rgbHex: String,

    @SerializedName("restricted")
    val restricted: Boolean,

    @SerializedName("restricted_msg")
    val restrictedMsg: String,

    @SerializedName("on_sale")
    val onSale: Boolean,

    @SerializedName("discount_rate")
    val discountRate: Int,

    @SerializedName("sale_start_date")
    val saleStartDate: String,

    @SerializedName("sale_end_date")
    val saleEndDate: String,

    @SerializedName("subscribe_cnt")
    val subscribeCnt: Int,

    @SerializedName("like_cnt")
    val likeCnt: Int,

    @SerializedName("view_cnt")
    val viewCnt: Int,

    @SerializedName("up")
    val up: Boolean,

    @SerializedName("blurb")
    val blurb: String,

    @SerializedName("sub_title")
    val subTitle: String,

    @SerializedName("genre")
    val genre: Genre,

    @SerializedName("rect_banner_url")
    val rectBannerUrl: String


    )
