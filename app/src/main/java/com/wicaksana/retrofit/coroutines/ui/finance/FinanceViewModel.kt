package com.wicaksana.retrofit.coroutines.ui.finance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wicaksana.retrofit.coroutines.data.model.YahooStatis
import com.wicaksana.retrofit.coroutines.data.repository.MainRepository

class FinanceViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    private val _data = MutableLiveData<ArrayList<YahooStatis>>()
    val data: LiveData<ArrayList<YahooStatis>> = _data

    fun postYahooStatis(category: String, type: String, value: Int) {
        mainRepository.postYahooStatis(category, type, value,
            object : MainRepository.ResponseCallback {
                override fun onSuccess(message: String?, data: ArrayList<YahooStatis>?) {
                    _msg.value = message
                    _data.value = data
                }

                override fun onFail(message: String?) {
                    _msg.value = message
                }
            })
    }
}