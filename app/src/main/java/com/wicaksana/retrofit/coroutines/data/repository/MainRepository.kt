package com.wicaksana.retrofit.coroutines.data.repository

import com.wicaksana.retrofit.coroutines.data.api.ApiService
import com.wicaksana.retrofit.coroutines.data.model.ResponseYahooStatis
import com.wicaksana.retrofit.coroutines.data.model.YahooStatis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(private val apiService: ApiService) {
    interface ResponseCallback {
        fun onSuccess(message: String?, data: ArrayList<YahooStatis>?)
        fun onFail(message: String?)
    }

    fun postYahooStatis(category: String, type: String, value: Int, responseCallback: ResponseCallback) {
        apiService.postYahooStatis(category, type, value).enqueue(object :
            Callback<ResponseYahooStatis> {
            override fun onResponse(
                call: Call<ResponseYahooStatis>,
                response: Response<ResponseYahooStatis>
            ) {
                if (response.isSuccessful) {
                    val yahooStatis = ArrayList<YahooStatis>()
                    for (i in response.body()?.data!!) {
                        val model = YahooStatis(
                            i.id,
                            i.date,
                            i.symbol,
                            i.roa,
                            i.pbv,
                            i.eps,
                            i.roe,
                            i.der,
                            i.dy,
                            i.relationSymbol.symbol,
                            i.marketshare,
                            i.per
                        )
                        yahooStatis.add(model)
                    }
                    responseCallback.onSuccess(response.body()?.message, yahooStatis)
                }
            }

            override fun onFailure(call: Call<ResponseYahooStatis>, t: Throwable) {
                responseCallback.onFail(t.message.toString())
            }
        })
    }
}