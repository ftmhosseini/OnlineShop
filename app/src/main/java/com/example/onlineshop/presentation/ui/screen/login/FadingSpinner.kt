package com.example.onlineshop.presentation.ui.screen.login

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun FadingSpinner(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    spokeCount: Int = 12,
    spokeLength: Dp = 12.dp,
    spokeWidth: Dp = 3.dp,
    durationMillis: Int = 1500
) {
    val infiniteTransition = rememberInfiniteTransition()
    val animatedRotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = LinearEasing)
        )
    )

    Canvas(modifier = modifier) {
        val radius = size.minDimension / 2f
        val center = Offset(size.width / 2, size.height / 2)

        for (i in 0 until spokeCount) {
            val angle = Math.toRadians((i * (360f / spokeCount).toDouble())).toFloat()
            val rotationFraction = ((animatedRotation / 360f) * spokeCount).toInt()
            val alphaIndex = (i - rotationFraction + spokeCount) % spokeCount
            val alpha = (1f - alphaIndex / spokeCount.toFloat()).coerceIn(0.2f, 1f)

            val start = Offset(
                x = center.x + cos(angle) * (radius - spokeLength.toPx()),
                y = center.y + sin(angle) * (radius - spokeLength.toPx())
            )
            val end = Offset(
                x = center.x + cos(angle) * radius,
                y = center.y + sin(angle) * radius
            )

            drawLine(
                color = color.copy(alpha = alpha),
                start = start,
                end = end,
                strokeWidth = spokeWidth.toPx(),
                cap = StrokeCap.Round
            )
        }
    }
}

