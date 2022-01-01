package com.wicaksana.retrofit.coroutines.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class YahooStatis(
    val id: Int,
    val date: String,
    val symbol: Int,
    val roa: Double,
    val pbv: Double,
    val eps: Double,
    val roe: Double,
    val der: Double,
    val dy: Double,
    val relationSymbol: String,
    val marketshare: Double,
    val per: Double
): Parcelable
