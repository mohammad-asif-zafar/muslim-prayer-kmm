package com.hathway.muslimprayerkmm.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        PrayerHeader()
        
        CountdownTimer()
        
        // Simple prayer times list in one column
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(prayerTimes) { prayer ->
                PrayerCard(
                    prayer = prayer,
                    onToggle = { /* TODO: Handle toggle */ }
                )
            }
        }
    }
}
