package com.ipa.dev.harrypottercompose.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ipa.dev.harrypottercompose.ui.ScreenAppTheme

enum class HomeButtonOptions {
    CHARACTERS, HOUSES, SPELLS
}
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onButtonClick: (HomeButtonOptions) -> Unit
) {
    ScreenAppTheme {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = modifier
            )
            Button(
                onClick = { onButtonClick(HomeButtonOptions.CHARACTERS) },
                modifier = modifier
                    .size(150.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                ),
                shape = RectangleShape
            ) {
                Text(
                    text = HomeButtonOptions.CHARACTERS.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }

            Button(
                onClick = { onButtonClick(HomeButtonOptions.HOUSES) },
                modifier = modifier
                    .size(150.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                ),
                shape = RectangleShape
            ) {
                Text(
                    text = HomeButtonOptions.HOUSES.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }

            Button(
                onClick = { onButtonClick(HomeButtonOptions.SPELLS) },
                modifier = modifier
                    .size(150.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                ),
                shape = RectangleShape
            ) {
                Text(
                    text = HomeButtonOptions.SPELLS.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }

            Spacer(
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onButtonClick = {})
}