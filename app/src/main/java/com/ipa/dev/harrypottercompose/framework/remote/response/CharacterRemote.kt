package com.ipa.dev.harrypottercompose.framework.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CharacterRemote(
    val id: String,
    val name: String,
    @SerialName("alternate_names") val alternateNames: List<String>?,
    val species: String?,
    val gender: String?,
    val house: String?,
    val dateOfBirth: String?,
    val yearOfBirth: Int?,
    val wizard: Boolean?,
    val ancestry: String?,
    val eyeColour: String?,
    val hairColour: String?,
    val wand: Wand?,
    val patronus: String?,
    val hogwartsStudent: Boolean?,
    val hogwartsStaff: Boolean?,
    val actor: String?,
    @SerialName("alternate_actors") val alternateActors: List<String>?,
    val alive: Boolean?,
    val image: String?
)

@Serializable
data class Wand(
    val wood: String?,
    val core: String?,
    val length: Double?
)