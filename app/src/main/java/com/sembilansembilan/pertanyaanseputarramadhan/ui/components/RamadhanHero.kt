package com.sembilansembilan.pertanyaanseputarramadhan.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.sembilansembilan.pertanyaanseputarramadhan.ui.theme.Champagne
import com.sembilansembilan.pertanyaanseputarramadhan.ui.theme.IvorySurfaceLight
import com.sembilansembilan.pertanyaanseputarramadhan.ui.theme.MidnightGradient
import com.sembilansembilan.pertanyaanseputarramadhan.ui.theme.MidnightPrimaryLight

@Composable
fun RamadhanHero(content: @Composable ColumnScope.() -> Unit) {
    Box(
        Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.large)
            .background(Brush.linearGradient(listOf(MidnightPrimaryLight, MidnightGradient)))
    ) {
        Canvas(Modifier.matchParentSize()) {
            val corner = Offset(size.width * 0.99f, size.height * 0.04f)
            val ring = Champagne.copy(alpha = 0.16f)
            for (radius in listOf(34.dp, 54.dp, 74.dp)) {
                drawCircle(ring, radius.toPx(), center = corner, style = Stroke(1.dp.toPx()))
            }
        }
        CompositionLocalProvider(LocalContentColor provides IvorySurfaceLight) {
            Column(Modifier.fillMaxWidth().padding(20.dp), content = content)
        }
    }
}
