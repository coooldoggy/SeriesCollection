package com.coooldoggy.seriescollection.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.coooldoggy.seriescollection.databinding.FragmentDetailViewBinding

class SeriesDetailViewFragment: Fragment() {
    private val TAG = SeriesDetailViewFragment::class.java.simpleName
    private lateinit var dataBinding: FragmentDetailViewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = FragmentDetailViewBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}