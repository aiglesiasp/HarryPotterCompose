package com.ipa.dev.harrypottercompose.ui.screens.houses.home

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ipa.dev.harrypottercompose.ui.ScreenAppTheme
import com.ipa.dev.harrypottercompose.ui.screens.home.HomeButtonOptions

enum class HousesButtonOptions(val house: String) {
    GRYFFINDOR("gryffindor"),
    RAVENCLAW("ravenclaw"),
    SLYTHERIN("slytherin"),
    HUFFLEPUFF("hufflepuff")
}
@Composable
fun HousesScreen(
    onButtonClick: (HousesButtonOptions) -> Unit,
    modifier: Modifier = Modifier
) {
    ScreenAppTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
        ) {
            Spacer(
                modifier = modifier
            )

            Button(
                onClick = { onButtonClick(HousesButtonOptions.GRYFFINDOR) },
                modifier = modifier
                    .size(150.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFCD373C),
                    contentColor = Color.Black
                ),
                shape = RectangleShape
            ) {
                Text(
                    text = HousesButtonOptions.GRYFFINDOR.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }

            Button(
                onClick = { onButtonClick(HousesButtonOptions.RAVENCLAW) },
                modifier = modifier
                    .size(150.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0F1D4A),
                    contentColor = Color.White
                ),
                shape = RectangleShape
            ) {
                Text(
                    text = HousesButtonOptions.RAVENCLAW.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }

            Button(
                onClick = { onButtonClick(HousesButtonOptions.SLYTHERIN) },
                modifier = modifier
                    .size(150.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1A472A),
                    contentColor = Color.White
                ),
                shape = RectangleShape
            ) {
                Text(
                    text = HousesButtonOptions.SLYTHERIN.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }

            Button(
                onClick = { onButtonClick(HousesButtonOptions.HUFFLEPUFF) },
                modifier = modifier
                    .size(150.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFECB939),
                    contentColor = Color.Black
                ),
                shape = RectangleShape
            ) {
                Text(
                    text = HousesButtonOptions.HUFFLEPUFF.name,
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HousesScreenPreview() {
    HousesScreen(onButtonClick = {})
}