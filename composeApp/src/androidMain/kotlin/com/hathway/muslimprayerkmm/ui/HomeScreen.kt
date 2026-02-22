package com.hathway.muslimprayerkmm.ui

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.hathway.muslimprayerkmm.presentation.model.PrayerUiModel

@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Composable
actual fun HomeScreen() {
    var slideDirection by remember { mutableStateOf(1) }

    var selectedDay by remember { mutableStateOf(17) }

    val dateText = "$selectedDay February 2026"

    val prayerTimes = remember {
        listOf(
            PrayerUiModel("Fajr", "05:54 AM", "🌅", true, isPast = true),
            PrayerUiModel("Dhuhr", "01:22 PM", "☀️", false, isCurrent = true),
            PrayerUiModel("Asr", "04:46 PM", "🌤", false, isNext = true),
            PrayerUiModel("Maghrib", "07:21 PM", "🌅", false),
            PrayerUiModel("Isha", "08:33 PM", "🌙", false)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF5F5F5), Color(0xFFE8F5E8)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 24.dp),
            verticalArrangement = Arrangement.Top
        ) {
            PrayerHeader(
                location = "Kuala lumpur",
                hijriDate = "Jumada Al Akhira 15, 1446 AH",
                onLocationClick = { /* TODO: Handle location click */ },
                onInfoClick = { /* TODO: Handle info click */ },
                onNotificationClick = { /* TODO: Handle notification click */ },
                gregorianDate = "17th Feb 2026"
            )

            Spacer(modifier = Modifier.height(10.dp))

            CountdownTimer(
                state = CountdownUiState(
                    prayerType = PrayerType.Maghrib, progress = 0.7f, timeText = "24:44"
                )
            )

            Column {
                PrayerDateSwitcher(
                    dateText = dateText,
                    onPreviousClick = {
                        slideDirection = -1
                        selectedDay--
                    },
                    onNextClick = {
                        slideDirection = 1
                        selectedDay++
                    }
                )
            }

            AnimatedContent(
                targetState = selectedDay,
                transitionSpec = {
                    (slideInHorizontally { slideDirection * it } + fadeIn())
                        .togetherWith(
                            slideOutHorizontally { -slideDirection * it } + fadeOut()
                        )
                },
                label = "prayerListSlide"
            ) {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(prayerTimes) { prayer ->
                        PrayerCard(
                            prayer = prayer,
                            onToggle = { }
                        )
                    }
                }
            }
            /*LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(prayerTimes) { prayer ->
                    PrayerCard(
                        prayer = prayer, onToggle = { })
                }
            }*/
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen()
    }
}
