package com.devspacecomposeinit

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "artistList"
    ) {
        composable(route = "artistList") {
            ArtistListScreen(navController = navController)
        }

        composable(
            route = "artistDetail" + "/{itemID}",
            arguments = listOf(navArgument("itemID") { type = NavType.IntType })
        ) { backStackEntry ->
            val artistID = requireNotNull(backStackEntry.arguments?.getInt("itemID"))
            ArtistDetailScreen(artistID = artistID, navController)
        }
    }
}