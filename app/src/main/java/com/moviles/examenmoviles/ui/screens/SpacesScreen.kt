package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.data.SimulatedData
import com.moviles.examenmoviles.data.Space
import com.moviles.examenmoviles.ui.components.SpaceCard
import com.moviles.examenmoviles.ui.theme.AppBackground
import com.moviles.examenmoviles.ui.theme.AppPrimary
import com.moviles.examenmoviles.ui.theme.AppSecondaryText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpacesScreen(
    onSpaceClick: (Space) -> Unit
) {
    val spaces = SimulatedData.getSpaces()

    Scaffold(
        containerColor = AppBackground,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Coworking Spaces",
                        style = MaterialTheme.typography.headlineMedium,
                        color = AppPrimary
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = AppBackground
                )
            )
        }
    ) { paddingValues ->
        if (spaces.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No spaces available",
                    style = MaterialTheme.typography.bodyLarge,
                    color = AppSecondaryText
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(spaces) { space ->
                    SpaceCard(
                        space = space,
                        onClick = { onSpaceClick(space) }
                    )
                }
            }
        }
    }
}