package com.hathway.muslimprayerkmm.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hathway.muslimprayerkmm.presentation.model.PrayerUiModel

@Composable
actual fun PrayerCard(
    prayer: PrayerUiModel,
    onToggle: (Boolean) -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }
    
    val animatedCardColor by animateColorAsState(
        targetValue = if (prayer.isNotificationEnabled) Color(0xFF0A4D3C) else Color.White,
        animationSpec = tween(durationMillis = 300),
        label = "cardColor"
    )
    
    val animatedBorderColor by animateColorAsState(
        targetValue = if (isPressed) Color(0xFF0A4D3C) else Color.Transparent,
        animationSpec = tween(durationMillis = 200),
        label = "borderColor"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .border(
                width = if (isPressed) 2.dp else 0.dp,
                color = animatedBorderColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { 
                isPressed = !isPressed
                onToggle(!prayer.isNotificationEnabled)
            },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = animatedCardColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left side: Icon and prayer info
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Prayer icon
                Text(
                    text = prayer.icon,
                    fontSize = 24.sp,
                    color = if (prayer.isNotificationEnabled) Color.White else Color(0xFF0A4D3C)
                )
                
                // Prayer name and time
                Column {
                    Text(
                        text = prayer.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (prayer.isNotificationEnabled) Color.White else Color(0xFF0A4D3C)
                    )
                    Text(
                        text = prayer.time,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = if (prayer.isNotificationEnabled) 
                            Color.White.copy(alpha = 0.8f) 
                        else 
                            Color(0xFF0A4D3C).copy(alpha = 0.7f)
                    )
                }
            }
            
            // Right side: Toggle switch
            Switch(
                checked = prayer.isNotificationEnabled,
                onCheckedChange = { 
                    onToggle(it)
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF0A4D3C),
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color.LightGray
                )
            )
        }
    }
}
