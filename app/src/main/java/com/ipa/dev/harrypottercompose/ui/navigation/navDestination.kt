package com.ipa.dev.harrypottercompose.ui.navigation

import com.ipa.dev.harrypottercompose.ui.screens.houses.home.HousesButtonOptions
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object Character

@Serializable
object Houses

@Serializable
data class HousesDetail(val name: String)

@Serializable
object Spells