package com.ipa.dev.harrypottercompose.framework.remote.api

import com.ipa.dev.harrypottercompose.framework.remote.response.CharacterRemote
import com.ipa.dev.harrypottercompose.framework.remote.response.SpellRemote
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET("/api/characters")
    suspend fun fetchAllCharacters(): List<CharacterRemote>

    @GET("/api/characters/house/{name}")
    suspend fun fetchCharactersByHouse(@Path("name") name: String): List<CharacterRemote>
}