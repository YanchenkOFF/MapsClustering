package com.example.mapsclustering.domain

interface BankRepository {
    suspend fun getAllAtms(): List<Atm>
    suspend fun getAllInf(): List<Infobox>
}