package com.example.passwordstore.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.passwordstore.MainViewModel
import com.example.passwordstore.MainViewModelFactory
import com.example.passwordstore.navigation.NavRoute
import com.example.passwordstore.ui.theme.PasswordStoreTheme

@Composable
fun StartScreen(navController: NavHostController, viewModel: MainViewModel)
{
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))


    Scaffold(modifier = Modifier.fillMaxSize())
    {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
        {
            Text(text = "NillingKiggers")
            Button(onClick = {navController.navigate(route = NavRoute.Main.route) }, modifier = Modifier
                .width(200.dp)
                .padding(vertical = 8.dp))
            {
                Text(text = "Button")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevStartScreen()
{
    PasswordStoreTheme()
    {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        StartScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}
