package dev.felipereis.learningcomposestuff.brush

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BrushExample() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Canvas(
            modifier = Modifier.size(200.dp),
            onDraw = {
                drawCircle(
                    Brush.sweepGradient(
                        colors = listOf(
                            Color.Red,
                            Color.Blue,
                            Color.Green,
                            Color.Yellow
                        )
                    )
                )
            }
        )

        Canvas(
            modifier = Modifier.size(200.dp),
            onDraw = {
                drawCircle(
                    Brush.radialGradient(
                        colors = listOf(
                            Color.Red,
                            Color.Blue,
                            Color.Green,
                            Color.Yellow
                        )
                    )
                )
            }
        )

        val infiniteTransition = rememberInfiniteTransition()
        val targetOffset = with(LocalDensity.current) {
            5000.dp.toPx()
        }
        val offset by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = targetOffset,
            animationSpec = infiniteRepeatable(tween(50000, easing = LinearEasing), repeatMode = RepeatMode.Reverse),
            label = "offset",
        )

        Spacer(
            modifier = Modifier
                .size(200.dp)
                .drawWithCache {
                    val brushSize = 400f
                    val brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Red,
                            Color.Blue,
                        ),
                        start = Offset(offset, offset),
                        end = Offset(offset + brushSize, offset + brushSize),
                        tileMode = TileMode.Mirror,
                    )

                    onDrawBehind {
                        drawRect(brush)
                    }
                },
        )
    }
}

@Composable
@Preview
fun BrushExamplePreview() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        BrushExample()
    }
}