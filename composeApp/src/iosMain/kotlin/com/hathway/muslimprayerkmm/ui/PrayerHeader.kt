package com.hathway.muslimprayerkmm.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow

// 🌿 Muted European-Islamic Gradient
private val HeaderGradient = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF2E6F64), Color(0xFF244E4A)
    )
)

private val HeaderShape = RoundedCornerShape(18.dp)

@Composable
actual fun PrayerHeader(
    location: String,
    hijriDate: String,
    gregorianDate: String,
    onLocationClick: () -> Unit,
    onInfoClick: () -> Unit,
    onNotificationClick: () -> Unit
) {

    Spacer(modifier = Modifier.height(60.dp))

    Box(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).shadow(4.dp, HeaderShape)
            .clip(HeaderShape).background(HeaderGradient)
            .padding(horizontal = 18.dp, vertical = 16.dp)
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {

            // Top Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier.clickable { onLocationClick() },
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Location",
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = location.substringBefore(","),
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {

                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Info",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp).clickable { onInfoClick() })

                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp).clickable { onNotificationClick() })
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = hijriDate,
                color = Color.White,
                fontSize = 19.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = gregorianDate, color = Color.White.copy(alpha = 0.85f), fontSize = 14.sp
            )
        }
    }
}

