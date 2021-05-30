package com.coooldoggy.seriescollection.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.coooldoggy.seriescollection.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_graph).navigateUp()
}