package com.rarited.timescorer.data

import androidx.lifecycle.*
import kotlinx.coroutines.launch


class TimerViewModel(private val repository: TSRepo) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allTSs: LiveData<List<TSDataEntity>> = repository.allTSs.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(tsDataEntity: TSDataEntity) = viewModelScope.launch {
        repository.tsInsert(tsDataEntity)
    }
}

class TimerViewModelFactory(private val repository: TSRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TimerViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TimerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}