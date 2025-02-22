package com.ipa.dev.harrypottercompose.framework.remote.api

import com.ipa.dev.harrypottercompose.framework.remote.response.SpellRemote
import retrofit2.http.GET

interface SpellsApiService {
    @GET("/api/spells")
    suspend fun fetchAllSpells(): List<SpellRemote>
}