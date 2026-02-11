//
// Created by Asif Zafar on 11/02/26.
//

import Foundation
import SwiftUI

struct PrayerRow: View {
    let name: String
    let time: String

    var body: some View {
        HStack {
            Text(name)
                .fontWeight(.medium)
            Spacer()
            Text(time)
                .fontWeight(.regular)
        }
        .padding(.vertical, 8)
    }
}

