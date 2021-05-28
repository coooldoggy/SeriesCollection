package com.coooldoggy.seriescollection.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coooldoggy.seriescollection.model.SeriesRepository
import com.coooldoggy.seriescollection.model.data.Series
import com.coooldoggy.seriescollection.ui.view.SeriesAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesListViewModel @Inject constructor(
    private val repository: SeriesRepository): ViewModel() {
    private val TAG = SeriesListViewModel::class.java.simpleName
    private val _currentPage = MutableLiveData<Int>(1)
    private val currentPage : LiveData<Int>
        get() = _currentPage
    private val _seriesList = MutableLiveData<ArrayList<Series>>()
    val seriesList: LiveData<ArrayList<Series>>
        get() = _seriesList
    val adapter = SeriesAdapter()

    init {
        getBrowseList()
    }

    private fun getBrowseList(){
        viewModelScope.launch {
            val result = repository.browseSeries(currentPage.value ?: 1)
            if (result.isSuccessful){
                _seriesList.postValue(result.body()?.series)
                Log.d(TAG, "getBrowseList $result")
            }
        }
    }
}