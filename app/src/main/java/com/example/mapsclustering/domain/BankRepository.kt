package com.example.mapsclustering.domain

import com.example.mapsclustering.domain.model.Atm
import com.example.mapsclustering.domain.model.Infobox

interface BankRepository {
    suspend fun getAllAtms(): List<Atm>
    suspend fun getAllInf(): List<Infobox>
}