package com.example.mapsclustering.data

import com.example.mapsclustering.domain.model.Atm
import com.example.mapsclustering.domain.BankRepository
import com.example.mapsclustering.domain.model.Infobox

class BankRepositoryImpl(private val api: BelarusbankBankAPI) : BankRepository {
    override suspend fun getAllAtms(): List<Atm> = api.getAllATM().map { it.toDomain() }
    override suspend fun getAllInf(): List<Infobox> = api.getAllInf().map { it.toDomain() }
}
