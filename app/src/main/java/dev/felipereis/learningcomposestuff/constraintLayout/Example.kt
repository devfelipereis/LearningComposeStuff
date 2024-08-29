package dev.felipereis.learningcomposestuff.constraintLayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ConstraintLayoutExample() {
    ConstraintLayout(
        modifier = Modifier
            .size(250.dp)
            .background(
                Color.Black.copy(alpha = 0.2f)
            )
    ) {
        val (avatar, name, buttonAtBottom) = createRefs()

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.Magenta)
                .constrainAs(avatar) {
                    top.linkTo(parent.top, margin = 16.dp)
                    centerHorizontallyTo(parent)
                }
        ) {
            Text(text = "FE")
        }

        Text(
            text = "Felipe Reis",
            modifier = Modifier.constrainAs(name) {
                top.linkTo(avatar.bottom, margin = 8.dp)
                centerHorizontallyTo(parent)
            }
        )

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(buttonAtBottom) {
                bottom.linkTo(parent.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
                width = Dimension.fillToConstraints
            }) {
            Text(text = "buttonAtBottom")
        }
    }
}

@Composable
@Preview
fun ConstraintLayoutExamplePreview() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        ConstraintLayoutExample()
    }
}