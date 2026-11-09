package com.sembilansembilan.pertanyaanseputarramadhan.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val DarkColorScheme = darkColorScheme(
    primary = MidnightPrimaryDark,
    onPrimary = MidnightOnPrimaryDark,
    primaryContainer = MidnightContainerDark,
    onPrimaryContainer = MidnightOnContainerDark,
    secondary = MidnightSecondaryDark,
    onSecondary = MidnightOnPrimaryDark,
    secondaryContainer = MidnightSurfaceVariantDark,
    onSecondaryContainer = MidnightOnSurfaceDark,
    tertiary = MidnightAccentDark,
    onTertiary = MidnightOnPrimaryDark,
    tertiaryContainer = MidnightContainerDark,
    onTertiaryContainer = MidnightOnContainerDark,
    background = MidnightBackgroundDark,
    onBackground = MidnightOnSurfaceDark,
    surface = MidnightSurfaceDark,
    surfaceVariant = MidnightSurfaceVariantDark,
    surfaceContainer = MidnightSurfaceDark,
    surfaceContainerHigh = MidnightSurfaceVariantDark,
    surfaceContainerHighest = MidnightSurfaceVariantDark,
    surfaceContainerLow = MidnightSurfaceDark,
    onSurface = MidnightOnSurfaceDark,
    onSurfaceVariant = MidnightOnSurfaceVariantDark,
    outline = MidnightOutlineDark,
    outlineVariant = MidnightSurfaceVariantDark,
    inverseSurface = IvorySurfaceLight,
    inverseOnSurface = MidnightOnSurfaceLight,
    inversePrimary = MidnightPrimaryLight,
)

private val LightColorScheme = lightColorScheme(
    primary = MidnightPrimaryLight,
    onPrimary = IvorySurfaceLight,
    primaryContainer = MidnightContainerLight,
    onPrimaryContainer = MidnightOnContainerLight,
    secondary = MidnightSecondaryLight,
    onSecondary = IvorySurfaceLight,
    secondaryContainer = MidnightContainerLight,
    onSecondaryContainer = MidnightOnContainerLight,
    tertiary = MidnightAccentLight,
    onTertiary = IvorySurfaceLight,
    tertiaryContainer = MidnightContainerLight,
    onTertiaryContainer = MidnightOnContainerLight,
    background = IvoryBackgroundLight,
    onBackground = MidnightOnSurfaceLight,
    surface = IvorySurfaceLight,
    surfaceVariant = IvorySurfaceVariantLight,
    surfaceContainer = IvorySurfaceLight,
    surfaceContainerHigh = IvorySurfaceLight,
    surfaceContainerHighest = IvorySurfaceLight,
    surfaceContainerLow = IvorySurfaceLight,
    onSurface = MidnightOnSurfaceLight,
    onSurfaceVariant = MidnightOnSurfaceVariantLight,
    outline = MidnightOutlineLight,
    outlineVariant = MidnightOutlineVariantLight,
    inverseSurface = MidnightSurfaceDark,
    inverseOnSurface = MidnightOnSurfaceDark,
    inversePrimary = MidnightPrimaryDark,
)

private val RamadhanShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(24.dp),
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
        shapes = RamadhanShapes,
        content = content
    )
}
