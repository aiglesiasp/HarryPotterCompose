package com.ipa.dev.harrypottercompose.data.local

import com.ipa.dev.harrypottercompose.framework.local.model.CharacterLocal

interface CharacterLocalDataSource {
    suspend fun getCharacters(): List<CharacterLocal>
    suspend fun insertCharacters(characters: List<CharacterLocal>)
    suspend fun getCharacterByName(name: String): List<CharacterLocal>
}


