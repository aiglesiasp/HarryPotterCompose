package com.ipa.dev.harrypottercompose.framework.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ipa.dev.harrypottercompose.framework.local.model.CharacterLocal

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters")
    suspend fun getCharacters(): List<CharacterLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<CharacterLocal>)

    @Query("SELECT * FROM characters WHERE name = :name" )
    suspend fun getCharacterByName(name: String): List<CharacterLocal>

}

