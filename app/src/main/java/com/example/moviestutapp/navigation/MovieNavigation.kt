package com.example.moviestutapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviestutapp.screens.details.DetailsScreen
import com.example.moviestutapp.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreen.HomeScreen.name) {
        composable(MovieScreen.HomeScreen.name) {
            //here we pass where this should lead us to
            HomeScreen(navController = navController)
        }
        //www.google.com/detail-screen/{movie}
        composable(
            MovieScreen.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") { type = NavType.StringType })
        ) { backStackEntry ->
            //key must be same as navArgument and must be as route
            //all must be the same
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie")
            )
        }

    }
}