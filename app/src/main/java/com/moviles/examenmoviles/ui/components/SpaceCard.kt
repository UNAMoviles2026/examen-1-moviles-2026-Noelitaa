package com.moviles.examenmoviles.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.data.Space

@Composable
fun SpaceCard(
    space: Space,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = space.name,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "Location: ${space.location}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp)
            )

            Row(
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = "Capacity: ${space.capacity} people",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = " Price: $${space.pricePerHour}/hour",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Text(
                text = if (space.isAvailable) "Available" else "Not available",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}