package com.ipa.dev.harrypottercompose.data

import com.ipa.dev.harrypottercompose.data.local.CharacterLocalDataSource
import com.ipa.dev.harrypottercompose.data.remote.CharacterRemoteDataSource
import com.ipa.dev.harrypottercompose.domain.CharacterRepository
import com.ipa.dev.harrypottercompose.domain.entities.Character
import com.ipa.dev.harrypottercompose.domain.entities.Wand
import com.ipa.dev.harrypottercompose.framework.local.model.CharacterLocal
import com.ipa.dev.harrypottercompose.framework.local.model.WandLocal
import com.ipa.dev.harrypottercompose.framework.remote.response.CharacterRemote
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterRemoteDataSource: CharacterRemoteDataSource,
    private val characterLocalDataSource: CharacterLocalDataSource
): CharacterRepository {
    override suspend fun getCharacters(): List<Character>
    {
        val localCharacters = characterLocalDataSource.getCharacters()
        if (localCharacters.isNotEmpty()) {
            return localCharacters.map { it.toDomainModel() }
        } else {
            val remoteCharacters = characterRemoteDataSource.getCharacters().map { it.toLocalModel() }
            characterLocalDataSource.insertCharacters(remoteCharacters)
            return characterLocalDataSource.getCharacters().map { it.toDomainModel() }
        }
    }

    override suspend fun getCharactersByHouse(name: String): List<Character> {
        val remoteCharacters = characterRemoteDataSource.getCharactersByHouse(name).map { it.toLocalModel() }
        return remoteCharacters.map { it.toDomainModel() }
        /*val localCharacters = characterLocalDataSource.getCharacterByName(name)
        if (localCharacters.isNotEmpty()) {
            return localCharacters.map { it.toDomainModel() }
        } else {
            val remoteCharacters = characterRemoteDataSource.getCharactersByHouse(name).map { it.toLocalModel() }
            characterLocalDataSource.insertCharacters(remoteCharacters)
            return characterLocalDataSource.getCharacterByName(name).map { it.toDomainModel() }
        }*/
    }
}

private fun CharacterRemote.toLocalModel(): CharacterLocal {
    return CharacterLocal(
        id = id,
        name = name,
        alternateNames = alternateNames ?: emptyList(),
        species = species ?: "",
        gender = gender ?: "",
        house = house ?: "",
        dateOfBirth = dateOfBirth ?: "",
        yearOfBirth = yearOfBirth ?: 0,
        wizard = wizard ?: false,
        ancestry = "",
        eyeColour = eyeColour ?: "",
        hairColour = hairColour ?: "",
        wand = WandLocal(
            wood ="",
            core = "",
            length = 0.0
        ),
        patronus = patronus ?: "",
        hogwartsStudent = hogwartsStudent ?: false,
        hogwartsStaff = hogwartsStaff ?: false,
        actor = actor ?: "",
        alternateActors = alternateActors ?: emptyList(),
        alive = alive ?: false,
        image = image ?: "",
    )
}



private fun CharacterLocal.toDomainModel(): Character {
    return Character(
        id = id,
        name = name,
        alternateNames = emptyList(),
        species = species ?: "",
        gender = gender ?: "",
        house = house ?: "",
        dateOfBirth = dateOfBirth ?: "",
        yearOfBirth = yearOfBirth ?: 0,
        wizard = wizard ?: false,
        eyeColour = eyeColour ?: "",
        hairColour = hairColour ?: "",
        wand = wand?.toDomainModel() ?: Wand("", "", 0.0),
        patronus = patronus ?: "",
        hogwartsStudent = hogwartsStudent ?: false,
        hogwartsStaff = hogwartsStaff ?: false,
        actor = actor ?: "",
        alternateActors = alternateActors ?: emptyList(),
        alive = alive ?: false,
        image = image ?: ""
    )
}

private fun WandLocal.toDomainModel(): Wand {
    return Wand(
        wood = wood ?: "",
        core = core ?: "",
        length = length ?: 0.0
    )
}