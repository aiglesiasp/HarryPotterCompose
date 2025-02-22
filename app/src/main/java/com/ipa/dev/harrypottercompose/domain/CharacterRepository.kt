package com.ipa.dev.harrypottercompose.domain

import android.content.Context
import com.ipa.dev.harrypottercompose.domain.entities.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
    suspend fun getCharactersByHouse(name: String): List<Character>
}