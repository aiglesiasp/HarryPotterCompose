package com.ipa.dev.harrypottercompose.ui.screens.spells

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipa.dev.harrypottercompose.domain.entities.Spell
import com.ipa.dev.harrypottercompose.ui.ScreenAppTheme

@Composable
fun SpellsScreen(
    viewModel: SpellsViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()

    ScreenAppTheme {
        Scaffold { padding ->
            if (uiState.value.isLoading) {
                CircularProgressIndicator(modifier = Modifier.padding(padding))
            } else {
                SpellList(
                    spells = uiState.value.spells,
                    modifier = Modifier.padding(padding)
                )
            }
        }
    }
}

@Composable
fun SpellList(spells: List<Spell>?, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.Absolute.Left,
    ) {
        items(spells ?: emptyList()) { spell ->
            SpellItem(
                spell = spell
            )
        }
    }
}

@Composable
fun SpellItem(spell: Spell, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clip(MaterialTheme.shapes.medium)
            .border(1.dp, Color.LightGray, MaterialTheme.shapes.medium)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = spell.name,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1,
                modifier = modifier.padding(8.dp)
            )

            Text(
                text = spell.description,
                style = MaterialTheme.typography.titleSmall,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}