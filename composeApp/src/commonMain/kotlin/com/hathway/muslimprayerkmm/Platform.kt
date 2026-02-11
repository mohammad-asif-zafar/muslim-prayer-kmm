package com.hathway.muslimprayerkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform