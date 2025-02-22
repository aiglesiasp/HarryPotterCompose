package com.ipa.dev.harrypottercompose.data.remote

import com.ipa.dev.harrypottercompose.framework.remote.response.CharacterRemote

interface CharacterRemoteDataSource {
    suspend fun getCharacters(): List<CharacterRemote>
    suspend fun getCharactersByHouse(name: String): List<CharacterRemote>
}