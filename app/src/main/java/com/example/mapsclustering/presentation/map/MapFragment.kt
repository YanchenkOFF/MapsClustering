package com.example.mapsclustering.presentation.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.mapsclustering.App
import com.example.mapsclustering.R
import com.example.mapsclustering.databinding.FragmentMapBinding
import com.example.mapsclustering.presentation.map.model.BankPoint
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.maps.android.clustering.ClusterManager

class MapFragment : Fragment() {
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    private lateinit var googleMap: GoogleMap
    private lateinit var mapFragment: SupportMapFragment
    private lateinit var clusterManager: ClusterManager<BankPoint>
    private var markers = emptyList<BankPoint>()
    private val viewModel: MapViewModel by viewModels {
        MapViewModelFactory(App.bankRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initGoogleMap()
    }

    private fun initGoogleMap() {
        mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync {
            googleMap = it
            setupMap()
        }
    }

    private fun setupMap() {
        clusterManager = ClusterManager<BankPoint>(requireContext(), googleMap)
        googleMap.setOnCameraIdleListener(clusterManager)
        val render = BankClusterRender(requireContext(), googleMap, clusterManager)
        clusterManager.renderer = render
        clusterManager.setAnimation(true)
        setupMapBindings()
    }

    private fun setupMapBindings() {
        lifecycleScope.launchWhenCreated {
            viewModel.state.collect { state ->
                markers = state.devices
                if (markers.isNotEmpty()) {
                    clusterManager.clearItems()
                    clusterManager.addItems(markers)
                    clusterManager.cluster()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}