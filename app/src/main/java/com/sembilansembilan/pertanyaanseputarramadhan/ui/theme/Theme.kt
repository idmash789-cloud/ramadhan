package com.sembilansembilan.pertanyaanseputarramadhan.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = PinePrimaryDark,
    onPrimary = PineOnPrimaryDark,
    primaryContainer = PineContainerDark,
    onPrimaryContainer = PineOnContainerDark,
    secondary = PineSecondaryDark,
    onSecondary = PineOnPrimaryDark,
    secondaryContainer = PineSurfaceVariantDark,
    onSecondaryContainer = PineOnSurfaceDark,
    tertiary = PineAccentDark,
    onTertiary = PineOnPrimaryDark,
    tertiaryContainer = PineContainerDark,
    onTertiaryContainer = PineOnContainerDark,
    background = PineBackgroundDark,
    onBackground = PineOnSurfaceDark,
    surface = PineSurfaceDark,
    surfaceVariant = PineSurfaceVariantDark,
    surfaceContainer = PineSurfaceDark,
    surfaceContainerHigh = PineSurfaceVariantDark,
    surfaceContainerHighest = PineSurfaceVariantDark,
    surfaceContainerLow = PineSurfaceDark,
    onSurface = PineOnSurfaceDark,
    onSurfaceVariant = PineOnSurfaceVariantDark,
    outline = PineOutlineDark,
    outlineVariant = PineSurfaceVariantDark,
    inverseSurface = IvorySurfaceLight,
    inverseOnSurface = PineOnSurfaceLight,
    inversePrimary = PinePrimaryLight,
)

private val LightColorScheme = lightColorScheme(
    primary = PinePrimaryLight,
    onPrimary = IvorySurfaceLight,
    primaryContainer = PineContainerLight,
    onPrimaryContainer = PineOnContainerLight,
    secondary = PineSecondaryLight,
    onSecondary = IvorySurfaceLight,
    secondaryContainer = PineContainerLight,
    onSecondaryContainer = PineOnContainerLight,
    tertiary = PineAccentLight,
    onTertiary = IvorySurfaceLight,
    tertiaryContainer = PineContainerLight,
    onTertiaryContainer = PineOnContainerLight,
    background = IvoryBackgroundLight,
    onBackground = PineOnSurfaceLight,
    surface = IvorySurfaceLight,
    surfaceVariant = IvorySurfaceVariantLight,
    surfaceContainer = IvorySurfaceLight,
    surfaceContainerHigh = IvorySurfaceLight,
    surfaceContainerHighest = IvorySurfaceLight,
    surfaceContainerLow = IvorySurfaceLight,
    onSurface = PineOnSurfaceLight,
    onSurfaceVariant = PineOnSurfaceVariantLight,
    outline = PineOutlineLight,
    outlineVariant = PineOutlineVariantLight,
    inverseSurface = PineSurfaceDark,
    inverseOnSurface = PineOnSurfaceDark,
    inversePrimary = PinePrimaryDark,
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
