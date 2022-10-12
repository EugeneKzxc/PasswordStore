package com.example.passwordstore.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.passwordstore.MainViewModel
import com.example.passwordstore.screens.AddScreen
import com.example.passwordstore.screens.MainScreen
import com.example.passwordstore.screens.NoteScreen
import com.example.passwordstore.screens.StartScreen

sealed class NavRoute(val route: String)
{
    object Start: NavRoute("StartScreen")
    object Main: NavRoute("HomeScreen")
    object Add: NavRoute("AddScreen")
    object Note: NavRoute("NoteScreen")
}

@Composable
fun NavHost(mViewModel: MainViewModel)
{
    val navController = rememberNavController()

    androidx.navigation.compose.NavHost(navController = navController, startDestination = NavRoute.Start.route,)
    {
        composable(NavRoute.Start.route){ StartScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Main.route){ MainScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Add.route){ AddScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Note.route){ NoteScreen(navController = navController, viewModel = mViewModel) }
    }
}