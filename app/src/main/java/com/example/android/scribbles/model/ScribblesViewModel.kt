package com.example.android.scribbles.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.scribbles.data.TaskNote
import kotlinx.coroutines.launch

class ScribblesViewModel() : ViewModel(){

    private val _taskNote = MutableLiveData<List<TaskNote>>()
    var taskNote: LiveData<List<TaskNote>> = _taskNote

    private fun getTaskNote(){
        viewModelScope.launch {
            _taskNote.value = mutableListOf(TaskNote())
        }
    }

}