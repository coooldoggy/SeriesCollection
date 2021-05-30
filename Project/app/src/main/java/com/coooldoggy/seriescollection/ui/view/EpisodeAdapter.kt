package com.coooldoggy.seriescollection.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coooldoggy.seriescollection.R
import com.coooldoggy.seriescollection.databinding.ItemEpisodeBinding
import com.coooldoggy.seriescollection.model.data.Episode

class EpisodeAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var episodeList = ArrayList<Episode>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_episode, parent, false)
        return EpisodeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = episodeList[position]
        val holder = holder as EpisodeViewHolder
        holder.apply {
            ivCover.clipToOutline = true
            bind(item)
        }
    }

    override fun getItemCount() = episodeList.size

    class EpisodeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var binding: ItemEpisodeBinding = ItemEpisodeBinding.bind(view)
        var ivCover = binding.ivEpisodeThumb

        fun bind(episode: Episode){
            binding.model = episode
        }
    }
}