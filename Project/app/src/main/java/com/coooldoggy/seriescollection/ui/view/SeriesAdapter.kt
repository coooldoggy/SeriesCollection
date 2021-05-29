package com.coooldoggy.seriescollection.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coooldoggy.seriescollection.R
import com.coooldoggy.seriescollection.databinding.ItemSeriesBinding
import com.coooldoggy.seriescollection.model.data.Series

class SeriesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
    var seriesList = ArrayList<Series>()

    fun setData(response: ArrayList<Series>, isLoadMore: Boolean){
        val currentItemCount = seriesList.size
        seriesList.addAll(response)
        if (isLoadMore){
            notifyItemRangeInserted(currentItemCount, seriesList.size)
        }else{
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_series, parent, false)
        return SeriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = seriesList[position]
        val holder = holder as SeriesViewHolder
        holder.apply {
            ivCover.clipToOutline = true
            bind(item)
            setImgUrl(item.bookCoverUrl ?: item.thumb.fileUrl)
        }
    }

    override fun getItemCount(): Int {
        return seriesList.size
    }

    class SeriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var binding: ItemSeriesBinding = ItemSeriesBinding.bind(view)
        var ivCover = binding.ivSeriesCover

        fun bind(series: Series){
            binding.model = series
        }

        fun setImgUrl(url: String){
            binding.coverUrl = url
        }
    }
}