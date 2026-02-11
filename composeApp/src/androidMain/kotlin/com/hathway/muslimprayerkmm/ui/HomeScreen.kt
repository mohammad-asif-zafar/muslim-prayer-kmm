package com.hathway.muslimprayerkmm.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import com.hathway.muslimprayerkmm.presentation.model.PrayerUiModel

@Composable
fun HomeScreen() {
    PrayerHomeCard(
        prayer = PrayerUiModel(
            location = "Kuala Lumpur",
            date = "Today • 11 Feb 2026",
            fajr = "05:54 AM",
            dhuhr = "01:22 PM",
            asr = "04:46 PM",
            maghrib = "07:21 PM",
            isha = "08:33 PM"
        )
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen()
    }
}
