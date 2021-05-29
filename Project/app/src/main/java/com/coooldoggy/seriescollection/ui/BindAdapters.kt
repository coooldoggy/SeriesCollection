package com.coooldoggy.seriescollection.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kotlin.math.roundToInt

object BindAdapters {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.context).load(url)
            .centerCrop()
            .into(view)
    }

    @BindingAdapter("likeCount")
    @JvmStatic
    fun setCountText(view: TextView, likeCnt: Int) {
        view.text = likeCnt.toLong().formatToShortNumber()
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