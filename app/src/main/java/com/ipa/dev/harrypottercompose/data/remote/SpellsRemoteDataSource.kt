package com.ipa.dev.harrypottercompose.data.remote

import com.ipa.dev.harrypottercompose.framework.remote.response.SpellRemote

interface SpellsRemoteDataSource {
    suspend fun fetchAllSpells(): List<SpellRemote>
}