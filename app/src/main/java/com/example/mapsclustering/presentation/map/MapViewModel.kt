package com.example.mapsclustering.presentation.map

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.mapsclustering.domain.BankRepository
import com.example.mapsclustering.presentation.map.mappers.toUi
import com.example.mapsclustering.presentation.map.model.BankPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class BankViewState(
    val devices: List<BankPoint> = emptyList()
)

class MapViewModel(private val bankRepository: BankRepository) : ViewModel() {
    private val _state = MutableStateFlow(BankViewState())
    val state get() = _state.asStateFlow()

    private var filtered = false
    private var defaultPoints = emptyList<BankPoint>()

    init {
        getAllDevices()
    }

    private fun getAllDevices() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val atmsDeferred = async { bankRepository.getAllAtms() }
                val infDeferred = async { bankRepository.getAllInf() }
                val allDevices = atmsDeferred.await().map { it.toUi() } + infDeferred.await().map { it.toUi() }
                withContext(Dispatchers.Main) {
                    defaultPoints = allDevices
                    _state.emit(state.value.copy(devices = allDevices))
                }
            } catch (e: Throwable) {
                Log.e(this@MapViewModel.javaClass.simpleName, "error", e)
            }
        }
    }

//    fun filterPoints() {
//        viewModelScope.launch {
//            val newList = if (filtered) {
//                val x = defaultPoints.filter { it.type != PointType.INFOBOX }
//                x
//            } else {
//                defaultPoints
//            }
//            filtered = !filtered
//            withContext(Dispatchers.Main) {
//                _state.emit(state.value.copy(devices = newList))
//            }
//        }
//    }
}

@Suppress("UNCHECKED_CAST")
class MapViewModelFactory(
    private val repository: BankRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MapViewModel(repository) as T
    }
}