package com.hathway.muslimprayerkmm.ui

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
import com.hathway.muslimprayerkmm.presentation.model.PrayerUiModel

@Composable
actual fun HomeScreen() {
    val prayerTimes = remember {
        listOf(
            PrayerUiModel("Fajr", "05:54 AM", "🌅", true),
            PrayerUiModel("Dhuhr", "01:22 PM", "☀️", false),
            PrayerUiModel("Asr", "04:46 PM", "🌤", false),
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
                        Color(0xFFF5F5F5),
                        Color(0xFFE8F5E8)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            PrayerHeader(
                location = "Kuala lumpur",
                hijriDate = "Jumada Al Akhira 15, 1446 AH",
                onLocationClick = { /* TODO: Handle location click */ },
                onInfoClick = { /* TODO: Handle info click */ },
                onNotificationClick = { /* TODO: Handle notification click */ },
                gregorianDate = "17th Feb 2026"
            )

            CountdownTimer(
                state = CountdownUiState(
                    prayerType = PrayerType.Maghrib,
                    progress = 0.7f,
                    timeText = "24:44"
                )
            )

            // Simple prayer times list in one column
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(prayerTimes) { prayer ->
                    PrayerCard(
                        prayer = prayer, onToggle = { /* TODO: Handle toggle */ })
                }
            }
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
