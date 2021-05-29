package com.coooldoggy.seriescollection.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.coooldoggy.seriescollection.model.data.Creator
import kotlinx.coroutines.flow.asFlow
import java.lang.StringBuilder

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

    @BindingAdapter("likeCount")
    @JvmStatic
    fun setCountText(view: TextView, likeCnt: Int) {
        view.text = likeCnt.toLong().formatToShortNumber()
    }

    @BindingAdapter("creatorName")
    @JvmStatic
    fun setCreator(view: TextView, creators: ArrayList<Creator>) {
        val creatorString = creators.joinToString {
            "${it.uname}"}
        view.text = creatorString
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