package com.wicaksana.retrofit.coroutines.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wicaksana.retrofit.coroutines.data.api.ApiHelper
import com.wicaksana.retrofit.coroutines.data.api.ApiService
import com.wicaksana.retrofit.coroutines.data.repository.MainRepository
import com.wicaksana.retrofit.coroutines.ui.finance.FinanceViewModel
import com.wicaksana.retrofit.coroutines.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiService: ApiService) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiService)) as T
        }
        if (modelClass.isAssignableFrom(FinanceViewModel::class.java)) {
            return FinanceViewModel(MainRepository(apiService)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}

