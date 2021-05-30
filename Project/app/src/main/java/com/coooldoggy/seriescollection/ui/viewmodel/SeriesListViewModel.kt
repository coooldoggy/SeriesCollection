package com.coooldoggy.seriescollection.ui.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coooldoggy.seriescollection.model.MainRepository
import com.coooldoggy.seriescollection.model.data.Pagination
import com.coooldoggy.seriescollection.model.data.Series
import com.coooldoggy.seriescollection.ui.view.SeriesAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesListViewModel @Inject constructor(
    private val repository: MainRepository): ViewModel() {
    private val TAG = SeriesListViewModel::class.java.simpleName
    private val _currentPage = MutableLiveData<Int>(1)
    private val currentPage : LiveData<Int>
        get() = _currentPage
    private val _seriesList = MutableLiveData<ArrayList<Series>>()
    val seriesList: LiveData<ArrayList<Series>>
        get() = _seriesList
    val adapter = SeriesAdapter()
    private val _progressBarStatus = MutableLiveData(View.GONE)
    val progressBarStatus : LiveData<Int>
        get() = _progressBarStatus
    private val hasNextPage = MutableLiveData<Boolean>(true)
    val isLoadMore = MutableLiveData<Boolean>(false)

    init {
        getBrowseList()
    }

    fun getBrowseList(){
        showProgressBar()
        viewModelScope.launch {
            if (hasNextPage.value == false){
                hideProgressBar()
                return@launch
            }
            kotlin.runCatching {
                val result = repository.browseSeries(currentPage.value ?: 1)
                if (result.isSuccessful){
                    result.body()?.pagination?.let { setNextPage(it) }
                    _seriesList.postValue(result.body()?.series)
                }
            }
            hideProgressBar()
        }
    }

    private fun setNextPage(page: Pagination){
        if (page.hasNext){
            _currentPage.postValue(page.page)
            isLoadMore.postValue(true)
        }
        hasNextPage.postValue(page.hasNext)
    }

    private fun showProgressBar(){
        _progressBarStatus.postValue(View.VISIBLE)
    }

    private fun hideProgressBar(){
        _progressBarStatus.postValue(View.GONE)
    }

}