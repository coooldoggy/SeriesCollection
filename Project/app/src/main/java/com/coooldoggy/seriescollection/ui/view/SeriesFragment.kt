package com.coooldoggy.seriescollection.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.coooldoggy.seriescollection.databinding.FragmentSeriesBinding
import com.coooldoggy.seriescollection.ui.viewmodel.SeriesListViewModel

class SeriesFragment: Fragment() {
    private val TAG = SeriesFragment::class.java.simpleName
    private lateinit var dataBinding: FragmentSeriesBinding
    private val viewModel by activityViewModels<SeriesListViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = FragmentSeriesBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setResources()
    }

    private fun setResources(){
        dataBinding.rvSeries.apply{
            layoutManager = StaggeredGridLayoutManager( 2, StaggeredGridLayoutManager.VERTICAL)
            adapter = viewModel.adapter
        }

        viewModel.seriesList.observe(viewLifecycleOwner, Observer {
            viewModel.adapter.seriesList = it
            viewModel.adapter.notifyDataSetChanged()
        })
    }
}