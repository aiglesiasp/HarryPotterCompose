package com.ipa.dev.harrypottercompose.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ipa.dev.harrypottercompose.ui.theme.HarryPotterComposeTheme

@Composable
fun ScreenAppTheme(content: @Composable () -> Unit) {
    HarryPotterComposeTheme {
       Surface(
           modifier = Modifier.fillMaxSize(),
           color = MaterialTheme.colorScheme.background,
           content = content
       )
    }
}