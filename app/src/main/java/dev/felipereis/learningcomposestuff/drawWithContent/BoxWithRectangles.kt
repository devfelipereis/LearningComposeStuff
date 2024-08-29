package dev.felipereis.learningcomposestuff.drawWithContent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoxWithRectangles() {
    var isPressed by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(200.dp)
            .background(Color.Black)
            .clickable {
                isPressed = !isPressed
            }
            .drawWithContent {
                drawContent()

                if (isPressed) {
                    drawRect(
                        color = Color.Yellow,
                        size = Size(size.width / 2, size.height / 2),
                        alpha = 0.5f,
                        style = Stroke(width = 8.dp.toPx())
                    )
                    drawRect(
                        topLeft = Offset(size.width - size.width / 3 - 8, size.height - size.height / 3 - 8),
                        color = Color.Yellow,
                        size = Size(size.width / 3, size.height / 3),
                        alpha = 0.5f,
                        style = Stroke(width = 8.dp.toPx())
                    )
                }
            }
    ) {
        Text(text = "Press Me", style = TextStyle(fontSize = 20.sp, color = Color.White))
    }
}

@Composable
@Preview
fun BoxWithRectanglesPreview() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        BoxWithRectangles()
    }
}