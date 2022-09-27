package com.example.mapsclustering.data

import com.example.mapsclustering.domain.Atm
import com.example.mapsclustering.domain.Infobox

internal fun AtmNW.toDomain() = Atm(
    address = address,
    city = city,
    lat = gpsX.toDouble(),
    lon = gpsY.toDouble(),
    id = id
)

internal fun InfoboxNW.toDomain() = Infobox(
    address = address,
    city = city,
    lat = gpsX.toDouble(),
    lon = gpsY.toDouble()
)
