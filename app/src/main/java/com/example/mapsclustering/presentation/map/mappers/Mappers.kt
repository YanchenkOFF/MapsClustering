package com.example.mapsclustering.presentation.map.mappers

import com.example.mapsclustering.domain.model.Atm
import com.example.mapsclustering.domain.model.Infobox
import com.example.mapsclustering.presentation.map.model.BankPoint
import com.example.mapsclustering.presentation.map.model.PointType
import com.google.android.gms.maps.model.LatLng


internal fun Atm.toUi() = BankPoint(
    type = PointType.ATM,
    geo = LatLng(lat, lon)
)

internal fun Infobox.toUi() = BankPoint(
    type = PointType.INFOBOX,
    geo = LatLng(lat, lon)
)

internal fun PointType.getTitle(): String {
    return when {
        this == PointType.ATM -> "ATM"
        this == PointType.INFOBOX -> "INF"
        else -> "Unknown"
    }
}

fun PointType.getSnippet(): String {
    return when {
        this == PointType.ATM -> "Банкомат - для снятия наличных денежных средств"
        this == PointType.INFOBOX -> "Инфокиоск - для соввершения безналичных операций"
        else -> "Unknown"
    }
}
