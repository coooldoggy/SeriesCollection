package com.coooldoggy.seriescollection.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.coooldoggy.seriescollection.R
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
        dataBinding.imgBtnBack.setOnClickListener {
            view.findNavController().popBackStack()
        }
        setResources()
    }

    private fun setResources(){
        dataBinding.rvEpisode.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModel.adapter
        }

        dataBinding.layoutHeaderSeries.ivSeriesCover.clipToOutline = true
        dataBinding.mlDetail.setTransitionListener(object : MotionLayout.TransitionListener{
            override fun onTransitionStarted(p0: MotionLayout?, startId: Int, endId: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, startId: Int, endId: Int, progress: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, currentId: Int) {
                if (currentId == R.id.start){
                    dataBinding.tvTitle.visibility = View.INVISIBLE
                }else{
                    dataBinding.tvTitle.visibility = View.VISIBLE
                }
            }

            override fun onTransitionTrigger(p0: MotionLayout?, triggerId: Int, positive: Boolean, progress: Float) {
            }
        })

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