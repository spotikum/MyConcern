package com.wicaksana.retrofit.coroutines.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseYahooStatis(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("message")
	val message: String
) : Parcelable

@Parcelize
data class DataItem(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("symbol")
	val symbol: Int,

	@field:SerializedName("roa")
	val roa: Double,

	@field:SerializedName("pbv")
	val pbv: Double,

	@field:SerializedName("eps")
	val eps: Double,

	@field:SerializedName("roe")
	val roe: Double,

	@field:SerializedName("der")
	val der: Double,

	@field:SerializedName("dy")
	val dy: Double,

	@field:SerializedName("relation_symbol")
	val relationSymbol: RelationSymbol,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("marketshare")
	val marketshare: Double,

	@field:SerializedName("per")
	val per: Double
) : Parcelable

@Parcelize
data class RelationSymbol(

	@field:SerializedName("symbol")
	val symbol: String,

	@field:SerializedName("id")
	val id: Int,
) : Parcelable
