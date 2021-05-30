package com.coooldoggy.seriescollection.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.coooldoggy.seriescollection.model.data.Creator
import java.text.SimpleDateFormat
import java.util.*

object BindAdapters {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(view: ImageView, url: String?) {
        if (url.isNullOrEmpty()){
            return
        }
        Glide.with(view.context).load(url)
            .centerCrop()
            .into(view)
    }

    @BindingAdapter("count")
    @JvmStatic
    fun setCountText(view: TextView, count: Int) {
        view.text = count.toLong().formatToShortNumber()
    }

    @BindingAdapter("creatorName")
    @JvmStatic
    fun setCreator(view: TextView, creators: ArrayList<Creator>) {
        val creatorString = creators.joinToString {
            "${it.uname}"}
        view.text = creatorString
    }

    @BindingAdapter("sceneNumber")
    @JvmStatic
    fun setSceneNumber(view: TextView, scene: Int) {
        view.text = "Episode $scene"
    }

    @BindingAdapter("dateTime")
    @JvmStatic
    fun setDateText(view: TextView, isodate: String){
        kotlin.runCatching {
            val isoFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            isoFormat.timeZone = TimeZone.getTimeZone("GMT")
            val dateResult = isoFormat.parse(isodate)
            val dateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH)
            view.text = dateFormat.format(dateResult)
        }.onFailure {
            it.printStackTrace()
        }
    }


    private fun Long.formatToShortNumber(): String {
        return when {
            this >= 1000000000 -> String.format("%.1fB", this / 1000000000.0)
            this >= 1000000 -> String.format("%.1fM", this / 1000000.0)
            this >= 1000 -> String.format("%.1fK", this / 1000.0)
            else -> this.toString()
        }
    }
}