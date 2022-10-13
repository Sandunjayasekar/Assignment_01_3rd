package com.sandun.myapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {
    private var data:MutableLiveData<String>? = null
    private var myVariable: String? = null

    fun getData(input: String): LiveData<String>? {
        if (data == null || myVariable != input) {
            myVariable = input
            data?.let { loadData(it, input) }
        }
        return data
    }

    private fun loadData(data: MutableLiveData<String>, input: String) {
     data.value = input;
    }
}