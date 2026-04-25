package com.moviles.examenmoviles.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.ui.theme.AppPrimary
import com.moviles.examenmoviles.ui.theme.AppSecondaryText

@Composable
fun DetailInfoRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = "$label: ",
            color = AppPrimary
        )
        Text(
            text = value,
            color = AppSecondaryText
        )
    }
}