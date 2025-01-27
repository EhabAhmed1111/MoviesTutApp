package com.example.moviestutapp.navigation

enum class MovieScreen {
    HomeScreen,
    DetailsScreen;

    companion object {
        //www.google.com/sign_in
        fun fromRoute(route: String?): MovieScreen = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}