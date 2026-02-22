package com.hathway.muslimprayerkmm.ui

import androidx.compose.runtime.Composable

@Composable
expect fun PrayerDateSwitcher(
    dateText: String,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
)
