package com.example.mapsclustering.data


import com.google.gson.annotations.SerializedName

data class AtmNW(
    @SerializedName("ATM_error")
    val aTMError: String,
    @SerializedName("ATM_printer")
    val aTMPrinter: String,
    @SerializedName("ATM_type")
    val aTMType: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("address_type")
    val addressType: String,
    @SerializedName("area")
    val area: String,
    @SerializedName("cash_in")
    val cashIn: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("city_type")
    val cityType: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("gps_x")
    val gpsX: String,
    @SerializedName("gps_y")
    val gpsY: String,
    @SerializedName("house")
    val house: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("install_place")
    val installPlace: String,
    @SerializedName("install_place_full")
    val installPlaceFull: String,
    @SerializedName("work_time")
    val workTime: String,
    @SerializedName("work_time_full")
    val workTimeFull: String
)
