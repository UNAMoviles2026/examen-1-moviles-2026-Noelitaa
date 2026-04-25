package com.moviles.examenmoviles.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.moviles.examenmoviles.data.SimulatedData
import com.moviles.examenmoviles.ui.screens.LoginScreen
import com.moviles.examenmoviles.ui.screens.SpaceDetailScreen
import com.moviles.examenmoviles.ui.screens.SpacesScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = "login") {
            LoginScreen(
                onLoginClick = {
                    navController.navigate("spaces") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(route = "spaces") {
            SpacesScreen(
                onSpaceClick = { space ->
                    navController.navigate("space_detail/${space.id}")
                }
            )
        }

        composable(
            route = "space_detail/{spaceId}",
            arguments = listOf(navArgument("spaceId") { type = NavType.StringType })
        ) { backStackEntry ->
            val spaceId = backStackEntry.arguments?.getString("spaceId")
            val space = SimulatedData.getSpaces().find { it.id == spaceId }

            if (space != null) {
                SpaceDetailScreen(
                    space = space,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}