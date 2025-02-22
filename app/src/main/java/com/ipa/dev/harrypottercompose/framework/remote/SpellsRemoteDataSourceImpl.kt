package com.ipa.dev.harrypottercompose.framework.remote

import com.ipa.dev.harrypottercompose.data.remote.SpellsRemoteDataSource
import com.ipa.dev.harrypottercompose.framework.remote.api.SpellsApiService
import com.ipa.dev.harrypottercompose.framework.remote.response.SpellRemote
import javax.inject.Inject

class SpellsRemoteDataSourceImpl @Inject constructor(
    private val spellsApiService: SpellsApiService
): SpellsRemoteDataSource {
    override suspend fun fetchAllSpells(): List<SpellRemote> = spellsApiService.fetchAllSpells()
}