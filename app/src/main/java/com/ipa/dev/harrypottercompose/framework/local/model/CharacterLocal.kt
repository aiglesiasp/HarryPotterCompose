package com.ipa.dev.harrypottercompose.framework.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity(tableName = "characters")
data class CharacterLocal(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "alternateNames") val alternateNames: List<String>?,
    @ColumnInfo(name = "species") val species: String?,
    @ColumnInfo(name = "gender") val gender: String?,
    @ColumnInfo(name = "house") val house: String?,
    @ColumnInfo(name = "dateOfBirth") val dateOfBirth: String?,
    @ColumnInfo(name = "yearOfBirth") val yearOfBirth: Int?,
    @ColumnInfo(name = "wizard") val wizard: Boolean?,
    @ColumnInfo(name = "ancestry") val ancestry: String?,
    @ColumnInfo(name = "eyeColour") val eyeColour: String?,
    @ColumnInfo(name = "hairColour") val hairColour: String?,
    @ColumnInfo(name = "wand") val wand: WandLocal?,
    @ColumnInfo(name = "patronus") val patronus: String?,
    @ColumnInfo(name = "hogwartsStudent") val hogwartsStudent: Boolean?,
    @ColumnInfo(name = "hogwartsStaff") val hogwartsStaff: Boolean?,
    @ColumnInfo(name = "actor") val actor: String?,
    @ColumnInfo(name = "alternateActors") val alternateActors: List<String>?,
    @ColumnInfo(name = "alive") val alive: Boolean?,
    @ColumnInfo(name = "image") val image: String?
)

data class WandLocal(
    val wood: String?,
    val core: String?,
    val length: Double?
)

class Converters {
    @TypeConverter
    fun fromListString(value: List<String>?): String? {
        return value?.joinToString(",")
    }

    @TypeConverter
    fun toListString(value: String?): List<String>? {
        return value?.split(",")
    }

    @TypeConverter
    fun fromWandLocal(value: WandLocal?): String? {
        return value?.let { "${it.wood},${it.core},${it.length}" }
    }

    @TypeConverter
    fun toWandLocal(value: String?): WandLocal? {
        if (value == null) return null
        val parts = value.split(",")
        return WandLocal(parts[0], parts[1], parts[2].toDouble())
    }
}