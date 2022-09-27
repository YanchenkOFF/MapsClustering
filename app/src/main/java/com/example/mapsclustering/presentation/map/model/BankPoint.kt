package com.example.mapsclustering.presentation.map.model

import androidx.annotation.DrawableRes
import com.example.mapsclustering.R
import com.example.mapsclustering.presentation.map.mappers.getSnippet
import com.example.mapsclustering.presentation.map.mappers.getTitle
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

data class BankPoint(
    val type: PointType,
    val geo: LatLng
) : ClusterItem {
    override fun getPosition(): LatLng {
        return geo
    }

    override fun getTitle(): String {
        return type.getTitle()
    }

    override fun getSnippet(): String {
        return type.getSnippet()
    }
}

enum class PointType(@DrawableRes val icon: Int) {
    ATM(R.drawable.ic_atm),
    INFOBOX(R.drawable.ic_info_box)
}