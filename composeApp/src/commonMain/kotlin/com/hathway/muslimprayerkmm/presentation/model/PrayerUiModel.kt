package com.hathway.muslimprayerkmm.presentation.model

data class PrayerUiModel(
    val name: String,
    val time: String,
    val icon: String,
    val isNotificationEnabled: Boolean = false,
    val isCurrent: Boolean = false,
    val isNext: Boolean = false,
    val isPast: Boolean = false
)
