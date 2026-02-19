package com.hathway.muslimprayerkmm.ui

import androidx.compose.runtime.Composable

@Composable
expect fun CountdownTimer(
    state: CountdownUiState

)

enum class PrayerType {
    Fajr, Dhuhr, Asr, Maghrib, Isha
}

data class CountdownUiState(
    val prayerType: PrayerType,
    val progress: Float,   // 0f..1f
    val timeText: String
)