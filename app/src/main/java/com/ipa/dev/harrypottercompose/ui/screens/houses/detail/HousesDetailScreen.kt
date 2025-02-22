package com.ipa.dev.harrypottercompose.ui.screens.houses.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipa.dev.harrypottercompose.ui.ScreenAppTheme
import com.ipa.dev.harrypottercompose.ui.screens.character.CharacterList
import com.ipa.dev.harrypottercompose.ui.screens.houses.home.HousesButtonOptions

@Composable
fun HousesDetailScreen(
    vm: HousesDetailViewModel = hiltViewModel()
) {

    val uiState = vm.uiState.collectAsState()

    ScreenAppTheme {
        Scaffold { padding ->
            if (uiState.value.isLoading) {
                CircularProgressIndicator(modifier = Modifier.padding(padding))
            } else {
                CharacterList(
                    characters = uiState.value.characters,
                    modifier = Modifier.padding(padding)
                )
            }
        }
    }

}