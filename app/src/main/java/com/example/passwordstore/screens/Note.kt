package com.example.passwordstore.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.passwordstore.MainViewModel
import com.example.passwordstore.MainViewModelFactory
import com.example.passwordstore.ui.theme.PasswordStoreTheme

@Composable
fun NoteScreen(navController: NavHostController, viewModel: MainViewModel)
{
    Scaffold(modifier = Modifier
        .fillMaxSize())
    {
        Column(modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement =  Arrangement.Center)
        {
            Card(modifier = Modifier
                .fillMaxSize()
                .padding(32.dp))
            {
                Column(modifier = Modifier.padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp))
                    {
                        Text(
                            text = "login",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp))
                    }
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp))
                    {
                        Text(
                            text = "password",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevNoteScreen()
{
    PasswordStoreTheme()
    {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        NoteScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}