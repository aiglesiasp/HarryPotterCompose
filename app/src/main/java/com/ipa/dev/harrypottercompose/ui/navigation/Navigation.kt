package com.ipa.dev.harrypottercompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ipa.dev.harrypottercompose.domain.entities.Spell
import com.ipa.dev.harrypottercompose.ui.screens.character.CharacterScreen
import com.ipa.dev.harrypottercompose.ui.screens.home.HomeButtonOptions
import com.ipa.dev.harrypottercompose.ui.screens.home.HomeScreen
import com.ipa.dev.harrypottercompose.ui.screens.houses.detail.HousesDetailScreen
import com.ipa.dev.harrypottercompose.ui.screens.houses.home.HousesButtonOptions
import com.ipa.dev.harrypottercompose.ui.screens.houses.home.HousesScreen
import com.ipa.dev.harrypottercompose.ui.screens.spells.SpellsScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(
                onButtonClick = { optionButton ->
                    when (optionButton) {
                        HomeButtonOptions.CHARACTERS -> navController.navigate(Character)
                        HomeButtonOptions.HOUSES -> navController.navigate(Houses)
                        HomeButtonOptions.SPELLS -> navController.navigate(Spells)
                    }
                }
            )
        }
        composable<Character> {
            CharacterScreen()
        }

        composable<Houses> {
            HousesScreen(
                onButtonClick = { housesButtonOptions ->
                    when (housesButtonOptions) {
                        HousesButtonOptions.GRYFFINDOR -> navController.navigate(HousesDetail(HousesButtonOptions.GRYFFINDOR.house))
                        HousesButtonOptions.RAVENCLAW -> navController.navigate(HousesDetail(HousesButtonOptions.RAVENCLAW.house))
                        HousesButtonOptions.SLYTHERIN -> navController.navigate(HousesDetail(HousesButtonOptions.SLYTHERIN.house))
                        HousesButtonOptions.HUFFLEPUFF -> navController.navigate(HousesDetail(HousesButtonOptions.HUFFLEPUFF.house))
                    }
                }
            )
        }

        composable<HousesDetail> {
            HousesDetailScreen()
        }

        composable<Spells> {
            SpellsScreen()
        }
    }
}
