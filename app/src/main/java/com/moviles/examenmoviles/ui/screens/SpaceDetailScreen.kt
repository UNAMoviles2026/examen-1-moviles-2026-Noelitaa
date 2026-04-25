package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.data.Space
import com.moviles.examenmoviles.ui.components.AppButton
import com.moviles.examenmoviles.ui.components.DetailInfoRow
import com.moviles.examenmoviles.ui.theme.AppBackground
import com.moviles.examenmoviles.ui.theme.AppPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceDetailScreen(
    space: Space,
    onBackClick: () -> Unit
) {
    Scaffold(
        containerColor = AppBackground,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = space.name,
                        color = AppPrimary
                    )
                },
                navigationIcon = {
                    androidx.compose.material3.IconButton(onClick = onBackClick) {
                        Text(text = "< Back", color = AppPrimary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = AppBackground
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            DetailInfoRow(
                label = "Location",
                value = space.location
            )

            DetailInfoRow(
                label = "Capacity",
                value = "${space.capacity} people"
            )

            DetailInfoRow(
                label = "Price",
                value = "$${space.pricePerHour} per hour"
            )

            DetailInfoRow(
                label = "Status",
                value = if (space.isAvailable) "Available" else "Not available"
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Description",
                color = AppPrimary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = space.description,
                color = AppPrimary.copy(alpha = 0.7f)
            )

            Spacer(modifier = Modifier.height(32.dp))

            AppButton(
                text = "Reserve",
                onClick = { println("Reserving ${space.name}") },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
