package com.ipa.dev.harrypottercompose.framework.local

import com.ipa.dev.harrypottercompose.data.local.CharacterLocalDataSource
import com.ipa.dev.harrypottercompose.framework.local.database.CharacterDao
import com.ipa.dev.harrypottercompose.framework.local.model.CharacterLocal
import javax.inject.Inject

class CharacterLocalDataSourceImpl @Inject constructor(
    private val characterDao: CharacterDao
): CharacterLocalDataSource {

    override suspend fun getCharacters(): List<CharacterLocal> {
        return characterDao.getCharacters()
    }

    override suspend fun insertCharacters(characters: List<CharacterLocal>) {
        characterDao.insertCharacters(characters)
    }

    override suspend fun getCharacterByName(name: String): List<CharacterLocal> {
        return characterDao.getCharacterByName(name)
    }
}


