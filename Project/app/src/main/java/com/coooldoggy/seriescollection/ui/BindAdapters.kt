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
        val mill = 1000000.0
        val klio = 1000.0
        if (likeCnt >= mill){
            val count = likeCnt.div(mill)
            view.text = "${(count * 10).roundToInt()}M"
        }else{
            val count = likeCnt.div(klio)
            view.text = "${(count * 10).roundToInt()}K"
        }
    }

}