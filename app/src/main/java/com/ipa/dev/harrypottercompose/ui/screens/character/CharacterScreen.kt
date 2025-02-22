package com.ipa.dev.harrypottercompose.ui.screens.character

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ipa.dev.harrypottercompose.domain.entities.Character
import com.ipa.dev.harrypottercompose.domain.entities.Wand
import com.ipa.dev.harrypottercompose.ui.ScreenAppTheme

@Composable
fun CharacterScreen(
    characterViewModel: CharacterViewModel = hiltViewModel()
){

    val uiState = characterViewModel.uiState.collectAsState()

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

@Composable
fun CharacterList(characters: List<Character>?, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(characters ?: emptyList()) { character ->
            CharacterItem(
                character = character,
                modifier = modifier,
                onClick = {}
            )
        }
    }
}

@Composable
fun CharacterItem(character: Character, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = modifier
            .padding(8.dp)
            .clip(MaterialTheme.shapes.medium)
            .border(1.dp, Color.LightGray, MaterialTheme.shapes.medium),
        onClick = onClick
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxWidth()
                    .aspectRatio(2 / 3f)
                    .clip(MaterialTheme.shapes.medium)
            )
            Text(
                text = character.name,
                style = MaterialTheme.typography.titleSmall,
                maxLines = 1,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CharacterItemPreview() {
    CharacterItem(
        character = Character(
            id = "1",
            name = "Harry Potter",
            alternateNames = listOf(),
            species = "human",
            gender = "male",
            house = "Gryffindor",
            dateOfBirth = "31-07-1980",
            yearOfBirth = 198,
            wizard = true,
            eyeColour = "green",
            hairColour = "black",
            wand = Wand("oak", "unicorn tail hair", 11.0),
            patronus = "stag",
            hogwartsStudent = true,
            hogwartsStaff = false,
            actor = "Daniel Radcliffe",
            alternateActors = listOf(),
            alive = true,
            image = "https://ik.imagekit.io/hpapi/harry.jpg"
        ),
        onClick = {}
    )
}
