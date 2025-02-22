package com.ipa.dev.harrypottercompose.framework.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class SpellRemote(
    val id: String,
    val name: String,
    val description: String
)
