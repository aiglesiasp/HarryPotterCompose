package com.ipa.dev.harrypottercompose.data

import com.ipa.dev.harrypottercompose.data.remote.SpellsRemoteDataSource
import com.ipa.dev.harrypottercompose.domain.SpellsRepository
import com.ipa.dev.harrypottercompose.domain.entities.Spell
import com.ipa.dev.harrypottercompose.framework.remote.response.SpellRemote
import javax.inject.Inject

class SpellsRepositoryImpl @Inject constructor(
    private val remoteDataSource: SpellsRemoteDataSource
) : SpellsRepository {
    override suspend fun fetchAllSpells(): List<Spell> = remoteDataSource.fetchAllSpells().map { it.toDomainModel() }
}

private fun SpellRemote.toDomainModel(): Spell {
    return Spell(
        id = id,
        name = name,
        description = description
    )
}