package com.hathway.muslimprayerkmm.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*@Composable
actual fun PrayerDateSwitcher(
    dateText: String, onPreviousClick: () -> Unit, onNextClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        shape = RoundedCornerShape(28.dp),
        tonalElevation = 3.dp,
        shadowElevation = 2.dp,
        color = Color(0xFFF4F6F5) // soft tinted background
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(
                onClick = onPreviousClick, modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Previous Day"
                )
            }

            Text(
                text = dateText, fontSize = 15.sp, fontWeight = FontWeight.Medium
            )

            IconButton(
                onClick = onNextClick, modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Next Day"
                )
            }
        }
    }
}*/

@Composable
actual fun PrayerDateSwitcher(
    dateText: String,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    var targetState by remember { mutableStateOf(dateText) }
    var slideDirection by remember { mutableStateOf(1) }

    LaunchedEffect(dateText) {
        targetState = dateText
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .pointerInput(Unit) {
                detectHorizontalDragGestures { change, dragAmount ->
                    if (dragAmount > 40) {
                        slideDirection = -1
                        onPreviousClick()
                    } else if (dragAmount < -40) {
                        slideDirection = 1
                        onNextClick()
                    }
                }
            }
    ) {
        AnimatedContent(
            targetState = targetState,
            transitionSpec = {
                slideInHorizontally { width ->
                    slideDirection * width
                } togetherWith slideOutHorizontally { width ->
                    -slideDirection * width
                }
            },
            label = "dateSlide"
        ) { animatedDate ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "‹",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .clickable {
                            slideDirection = -1
                            onPreviousClick()
                        }
                        .padding(8.dp)
                )

                Text(
                    text = animatedDate,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "›",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .clickable {
                            slideDirection = 1
                            onNextClick()
                        }
                        .padding(8.dp)
                )
            }
        }
    }
}
