package com.example.passwordstore.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.passwordstore.screens.Add
import com.example.passwordstore.screens.Main
import com.example.passwordstore.screens.Note

sealed class NavRoute(val route: String)
{
    object Main: NavRoute("HomeScreen")
    object Add: NavRoute("AddScreen")
    object Note: NavRoute("NoteScreen")
}

@Composable
fun NavHost()
{
    val navController = rememberNavController()

    androidx.navigation.compose.NavHost(navController = navController, startDestination = NavRoute.Main.route,)
    {
        composable(NavRoute.Main.route){ Main(navController = navController) }
        composable(NavRoute.Add.route){ Add(navController = navController) }
        composable(NavRoute.Note.route){ Note(navController = navController) }
    }

}