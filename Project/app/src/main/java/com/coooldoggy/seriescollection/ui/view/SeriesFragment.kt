package com.coooldoggy.seriescollection.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coooldoggy.seriescollection.databinding.FragmentSeriesBinding
import com.coooldoggy.seriescollection.ui.viewmodel.SeriesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesFragment: Fragment() {
    private val TAG = SeriesFragment::class.java.simpleName
    private lateinit var dataBinding: FragmentSeriesBinding
    private val viewModel by viewModels<SeriesListViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = FragmentSeriesBinding.inflate(inflater, container, false).apply {
            model = viewModel
            lifecycleOwner = this@SeriesFragment
        }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setResources()
    }

    private fun setResources(){
        dataBinding.rvSeries.apply{
            layoutManager = GridLayoutManager( context, 2)
            adapter = viewModel.adapter
            addOnScrollListener(rvScrollListener)
        }

        viewModel.seriesList.observe(viewLifecycleOwner, Observer {
            val loadMore = viewModel.isLoadMore.value ?: false
            viewModel.adapter.setData(it, loadMore)
        })
    }

    private val rvScrollListener = object : RecyclerView.OnScrollListener(){
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            val manager = recyclerView.layoutManager as GridLayoutManager
            if (manager.itemCount <= manager.findLastCompletelyVisibleItemPosition() + 2){
                viewModel.getBrowseList()
            }
        }
    }
}