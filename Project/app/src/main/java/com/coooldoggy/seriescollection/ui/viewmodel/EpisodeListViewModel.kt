package com.coooldoggy.seriescollection.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coooldoggy.seriescollection.model.MainRepository
import com.coooldoggy.seriescollection.model.data.Series
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeListViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    private val TAG = EpisodeListViewModel::class.java.simpleName
    val seriesItem = MutableLiveData<Series>()
    val coverUrl = MutableLiveData<String>()

    companion object {
        val KEY_SERIES_ITEM = "KEY_SERIES_ITEM"
    }

    fun setCoverUrl(item: Series){
        coverUrl.postValue(item.bookCoverUrl ?: item.thumb.fileUrl)
    }

    fun getSeriesItem(id: Int) {
        viewModelScope.launch {
            kotlin.runCatching {
                val result = repository.getSeries(id)
                if (result.isSuccessful) {
                    Log.d(TAG, "getSeriesItem $result")
                }
            }
        }
    }

    fun getEpisodes(id: Int){
        viewModelScope.launch {
            kotlin.runCatching {
                val result = repository.getEpisodes(id)
                if (result.isSuccessful) {
                    Log.d(TAG, "getEpisodes $result")
                }
            }
        }
    }
}