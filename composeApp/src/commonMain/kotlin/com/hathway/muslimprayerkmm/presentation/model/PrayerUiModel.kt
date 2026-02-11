package com.hathway.muslimprayerkmm.presentation.model

data class PrayerUiModel(
    val location: String,
    val date: String,
    val fajr: String,
    val dhuhr: String,
    val asr: String,
    val maghrib: String,
    val isha: String
)
