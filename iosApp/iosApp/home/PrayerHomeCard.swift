//
// Created by Asif Zafar on 11/02/26.
//

import Foundation
import SwiftUI
import shared

struct PrayerHomeCard: View {

    let prayer: PrayerUiModel

    var body: some View {
        VStack(alignment: .leading, spacing: 16) {

            Text(prayer.location)
                .font(.headline)
                .fontWeight(.bold)

            Text(prayer.date)
                .font(.caption)
                .foregroundColor(.gray)

            Divider()

            PrayerRow(name: "Fajr", time: prayer.fajr)
            PrayerRow(name: "Dhuhr", time: prayer.dhuhr)
            PrayerRow(name: "Asr", time: prayer.asr)
            PrayerRow(name: "Maghrib", time: prayer.maghrib)
            PrayerRow(name: "Isha", time: prayer.isha)
        }
        .padding(16)
        .background(
            RoundedRectangle(cornerRadius: 16)
                .fill(Color(.systemBackground))
                .shadow(radius: 6)
        )
        .padding(16)
    }
}


#Preview {
    PrayerHomeCard(
        prayer: PrayerUiModel(
            location: "Kuala Lumpur",
            date: "Today • 11 Feb 2026",
            fajr: "05:54 AM",
            dhuhr: "01:22 PM",
            asr: "04:46 PM",
            maghrib: "07:21 PM",
            isha: "08:33 PM"
        )
    )
    .padding()
}

