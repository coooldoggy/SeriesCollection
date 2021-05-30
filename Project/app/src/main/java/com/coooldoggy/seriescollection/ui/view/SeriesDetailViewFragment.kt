package com.coooldoggy.seriescollection.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.coooldoggy.seriescollection.databinding.FragmentDetailViewBinding
import com.coooldoggy.seriescollection.model.data.Series
import com.coooldoggy.seriescollection.ui.viewmodel.EpisodeListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesDetailViewFragment: Fragment() {
    private val TAG = SeriesDetailViewFragment::class.java.simpleName
    private lateinit var dataBinding: FragmentDetailViewBinding
    private val viewModel by viewModels<EpisodeListViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = FragmentDetailViewBinding.inflate(inflater, container, false).apply {
            model = viewModel
            lifecycleOwner = this@SeriesDetailViewFragment
        }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            viewModel.seriesItem.value = it.getSerializable(EpisodeListViewModel.KEY_SERIES_ITEM) as? Series
        }

        dataBinding.rvEpisode.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModel.adapter
        }

        dataBinding.imgBtnBack.setOnClickListener {
            view.findNavController().popBackStack()
        }

        dataBinding.layoutHeaderSeries.ivSeriesCover.clipToOutline = true

        viewModel.seriesItem.observe(viewLifecycleOwner, Observer {
            viewModel.getSeriesItem(it.id)
            viewModel.setCoverUrl(it)
        })

        viewModel.episodeList.observe(viewLifecycleOwner, Observer {
            viewModel.adapter.episodeList = it
            viewModel.adapter.notifyDataSetChanged()
        })
    }
}