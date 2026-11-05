package com.ajassistant.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF315CDB), onPrimary = Color.White,
    secondary = Color(0xFF52627A), background = Color(0xFFF7F8FC), surface = Color.White
)
private val DarkColors = darkColorScheme(
    primary = Color(0xFFB4C5FF), secondary = Color(0xFFC0C8DC)
)

@Composable
fun AJAssistantTheme(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = if (darkTheme) DarkColors else LightColors, content = content)
}
