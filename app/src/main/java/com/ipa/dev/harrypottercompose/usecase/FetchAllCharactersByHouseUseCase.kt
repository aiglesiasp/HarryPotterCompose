package com.ipa.dev.harrypottercompose.usecase

import com.ipa.dev.harrypottercompose.domain.CharacterRepository
import com.ipa.dev.harrypottercompose.domain.entities.Character
import javax.inject.Inject

class FetchAllCharactersByHouseUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(name: String): List<Character> = repository.getCharactersByHouse(name)
}