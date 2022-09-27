package com.example.mapsclustering.presentation.map

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat
import com.example.mapsclustering.R
import com.example.mapsclustering.presentation.map.model.BankPoint
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.Cluster
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer
import com.google.maps.android.ui.IconGenerator

private const val MARKER_COUNT = 10

class BankClusterRender(
    private val context: Context,
    googleMap: GoogleMap,
    clusterManager: ClusterManager<BankPoint>
) : DefaultClusterRenderer<BankPoint>(context, googleMap, clusterManager) {
    private val iconGenerator = IconGenerator(context)

    override fun shouldRenderAsCluster(cluster: Cluster<BankPoint>): Boolean {
        return cluster.size > MARKER_COUNT
    }

    override fun onBeforeClusterItemRendered(item: BankPoint, markerOptions: MarkerOptions) {
        val bitmap = bitmapDescriptorFromVector(context, item.type.icon)
        markerOptions.icon(bitmap)
    }

    override fun onBeforeClusterRendered(cluster: Cluster<BankPoint>, markerOptions: MarkerOptions) {
        iconGenerator.setBackground(getDrawable(context, R.drawable.ic_circle))
        val bitmap = iconGenerator.makeIcon(cluster.size.toString())
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap))
    }
}

fun bitmapDescriptorFromVector(context: Context, vectorResId: Int): BitmapDescriptor? {
    return ContextCompat.getDrawable(context, vectorResId)?.run {
        setBounds(0, 0, intrinsicWidth, intrinsicHeight)
        val bitmap =
            Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
        draw(Canvas(bitmap))
        BitmapDescriptorFactory.fromBitmap(bitmap)
    }
}
