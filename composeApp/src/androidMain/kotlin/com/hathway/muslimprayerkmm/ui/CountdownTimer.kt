package com.hathway.muslimprayerkmm.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
actual fun CountdownTimer(
    state: CountdownUiState
) {

    val animatedProgress by animateFloatAsState(
        targetValue = state.progress,
        animationSpec = tween(800),
        label = "progress"
    )

    val infiniteTransition = rememberInfiniteTransition(label = "breathing")

    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.02f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )

    val arcColor = when (state.prayerType) {
        PrayerType.Fajr -> Color(0xFF4A90E2)
        PrayerType.Dhuhr -> Color(0xFFFFB300)
        PrayerType.Asr -> Color(0xFFFF8F00)
        PrayerType.Maghrib -> Color(0xFFA14D12)
        PrayerType.Isha -> Color(0xFF3949AB)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        contentAlignment = Alignment.Center
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(200.dp)
                .scale(scale)
                .background(Color.White, CircleShape)
                .shadow(6.dp, CircleShape)
        ) {

            Canvas(modifier = Modifier.fillMaxSize()) {

                val strokeWidth = 10.dp.toPx()
                val radius = (size.minDimension / 2) - strokeWidth / 2

                drawCircle(
                    color = arcColor.copy(alpha = 0.15f),
                    radius = radius,
                    style = Stroke(width = strokeWidth)
                )

                drawArc(
                    brush = Brush.linearGradient(
                        listOf(arcColor, arcColor.copy(alpha = 0.8f))
                    ),
                    startAngle = -90f,
                    sweepAngle = 360f * animatedProgress,
                    useCenter = false,
                    size = Size(radius * 2, radius * 2),
                    style = Stroke(
                        width = strokeWidth,
                        cap = StrokeCap.Round
                    )
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = state.timeText,
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Medium,
                    color = arcColor,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Time Remaining",
                    fontSize = 13.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "for ${state.prayerType.name}",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = arcColor,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
