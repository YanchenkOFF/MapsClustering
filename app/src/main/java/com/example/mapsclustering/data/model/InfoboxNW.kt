package com.example.mapsclustering.data.model


import com.google.gson.annotations.SerializedName

data class InfoboxNW(
        @SerializedName("address")
        val address: String,
        @SerializedName("address_type")
        val addressType: String,
        @SerializedName("area")
        val area: String,
        @SerializedName("cash_in")
        val cashIn: String,
        @SerializedName("cash_in_exist")
        val cashInExist: String,
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
        @SerializedName("inf_printer")
        val infPrinter: String,
        @SerializedName("inf_status")
        val infStatus: String,
        @SerializedName("inf_type")
        val infType: String,
        @SerializedName("info_id")
        val infoId: Int,
        @SerializedName("install_place")
        val installPlace: String,
        @SerializedName("location_name_desc")
        val locationNameDesc: String,
        @SerializedName("popolnenie_platej")
        val popolneniePlatej: String,
        @SerializedName("region_platej")
        val regionPlatej: String,
        @SerializedName("time_long")
        val timeLong: String,
        @SerializedName("type_cash_in")
        val typeCashIn: String,
        @SerializedName("work_time")
        val workTime: String
    )