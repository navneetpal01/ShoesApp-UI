package com.example.shoesapp_ui.screens

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoesapp_ui.viewmodel.SharedViewModel

const val HOME_SCREEN = "Home"
const val PRODUCT_DETAILS_SCREEN = "Details"
private const val TRANSITION_UP_DURATION = 350
private const val TRANSITION_DOWN_DURATION = 250


@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val viewModel: SharedViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = HOME_SCREEN
    ) {
        composable(route = HOME_SCREEN) {
            HomeScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable(
            route = PRODUCT_DETAILS_SCREEN,
            enterTransition = {
                fadeIn(animationSpec = tween(TRANSITION_UP_DURATION)) + slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Up, animationSpec = tween(TRANSITION_UP_DURATION)
                )
            },
            exitTransition = {
                fadeOut(animationSpec = tween(TRANSITION_DOWN_DURATION)) + slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Down, animationSpec = tween(TRANSITION_DOWN_DURATION)
                )
            }
        ){
            ProductDetailsScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}