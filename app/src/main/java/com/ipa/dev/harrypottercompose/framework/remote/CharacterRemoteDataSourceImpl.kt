package com.ipa.dev.harrypottercompose.framework.remote

import com.ipa.dev.harrypottercompose.data.remote.CharacterRemoteDataSource
import com.ipa.dev.harrypottercompose.framework.remote.api.CharacterApiService
import com.ipa.dev.harrypottercompose.framework.remote.response.CharacterRemote
import javax.inject.Inject

class CharacterRemoteDataSourceImpl @Inject constructor(
    private val characterApiService: CharacterApiService
): CharacterRemoteDataSource {
    override suspend fun getCharacters(): List<CharacterRemote> = characterApiService.fetchAllCharacters()
    override suspend fun getCharactersByHouse(name: String): List<CharacterRemote> = characterApiService.fetchCharactersByHouse(name)
}