package com.sembilansembilan.pertanyaanseputarramadhan.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = GoldPrimaryDark,
    onPrimary = GoldOnPrimaryDark,
    primaryContainer = BrownPrimaryContainerDark,
    onPrimaryContainer = BrownOnPrimaryContainerDark,
    secondary = GoldSecondaryDark,
    tertiary = GoldTertiaryDark,
    background = DarkBackground,
    surface = DarkSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurface = DarkOnSurface,
    onSurfaceVariant = DarkOnSurfaceVariant
)

private val LightColorScheme = lightColorScheme(
    primary = BrownPrimaryLight,
    primaryContainer = BrownPrimaryContainerLight,
    onPrimaryContainer = BrownOnPrimaryContainerLight,
    secondary = BrownSecondaryLight,
    tertiary = GoldTertiaryLight,
    background = CreamBackgroundLight,
    surface = CreamSurfaceLight,
    surfaceVariant = CreamSurfaceVariantLight,
    onSurface = BrownOnSurfaceLight,
    onSurfaceVariant = BrownOnSurfaceVariantLight
)

@Composable
fun RamadhanTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
