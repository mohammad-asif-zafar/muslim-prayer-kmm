package com.hathway.muslimprayerkmm.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hathway.muslimprayerkmm.presentation.model.PrayerUiModel

@Composable
fun TimelinePrayerCard(
    prayer: PrayerUiModel,
    isFirst: Boolean = false,
    isLast: Boolean = false,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Minimalist Timeline
        Box(
            modifier = Modifier
                .width(32.dp)
                .height(50.dp),
            contentAlignment = Alignment.Center
        ) {
            // Subtle vertical line
            if (!isFirst || !isLast) {
                Canvas(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                ) {
                    val centerY = size.height / 2
                    drawLine(
                        color = Color(0xFFE0E0E0),
                        start = Offset(x = size.width / 2, y = if (isFirst) centerY else 0f),
                        end = Offset(x = size.width / 2, y = if (isLast) centerY else size.height),
                        strokeWidth = 1.dp.toPx()
                    )
                }
            }
            
            // Clean dot
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    )
                    .border(
                        width = 2.dp,
                        color = if (prayer.isNotificationEnabled) Color(0xFF2E6F64) else Color(0xFFE0E0E0),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (prayer.isNotificationEnabled) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .background(
                                color = Color(0xFF2E6F64),
                                shape = CircleShape
                            )
                    )
                }
            }
        }
        
        // Clean prayer info
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Prayer name and icon
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = prayer.icon,
                        fontSize = 22.sp,
                        modifier = Modifier.padding(end = 12.dp)
                    )
                    
                    Column {
                        Text(
                            text = prayer.name,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF1A1A1A),
                            letterSpacing = 0.2.sp
                        )
                        Text(
                            text = prayer.time,
                            fontSize = 14.sp,
                            color = Color(0xFF666666),
                            fontWeight = FontWeight.Normal,
                            letterSpacing = 0.1.sp
                        )
                    }
                }
                
                // Subtle status
                if (prayer.isNotificationEnabled) {
                    Text(
                        text = "•",
                        fontSize = 8.sp,
                        color = Color(0xFF4CAF50),
                        fontWeight = FontWeight.Bold
                    )
                } else {
                    Text(
                        text = "•",
                        fontSize = 8.sp,
                        color = Color(0xFFE0E0E0),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            
            // Subtle divider
            if (!isLast) {
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFF5F5F5))
                )
            }
        }
    }
}
