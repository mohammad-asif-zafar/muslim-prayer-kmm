package com.hathway.muslimprayerkmm.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 🌿 Muted European-Islamic Gradient
private val HeaderGradient = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF2E6F64), Color(0xFF244E4A)
    )
)

private val HeaderShape = RoundedCornerShape(18.dp)
private val ActionButtonSize = 30.dp

@Composable
actual fun PrayerHeader(
    location: String,          // Prefer: "Berlin"
    hijriDate: String,         // "Jumada Al Akhira 15, 1446 AH"
    gregorianDate: String,     // "17 February 2026"
    onLocationClick: () -> Unit, onInfoClick: () -> Unit, onNotificationClick: () -> Unit
) {

    Spacer(modifier = Modifier.height(48.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .shadow(4.dp, HeaderShape)
            .clip(HeaderShape)
            .background(HeaderGradient)
            .padding(horizontal = 18.dp, vertical = 16.dp)
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {

            // 🔹 Top Row (Location + Actions)
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {

                // 📍 Location Chip (Minimal + Premium)
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(40))
                        .background(Color.White.copy(alpha = 0.12f))
                        .border(
                            width = 0.8.dp,
                            color = Color.White.copy(alpha = 0.22f),
                            shape = RoundedCornerShape(40)
                        )
                        .clickable { onLocationClick() }
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically) {

                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = location,
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                HeaderActionButton(
                    icon = Icons.Default.Info, onClick = onInfoClick
                )

                Spacer(modifier = Modifier.width(6.dp))

                HeaderActionButton(
                    icon = Icons.Default.Notifications, onClick = onNotificationClick
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            // 🌙 Hijri Date (Primary)
            Text(
                text = hijriDate,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(4.dp))


            // 📅 Gregorian Date (Secondary)
            Text(
                text = gregorianDate,
                color = Color.White.copy(alpha = 0.85f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Composable
private fun HeaderActionButton(
    icon: ImageVector, onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(ActionButtonSize)

    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(16.dp)
        )
    }
}
