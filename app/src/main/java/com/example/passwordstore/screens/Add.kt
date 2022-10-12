package com.example.passwordstore.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
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
import com.example.passwordstore.model.Note
import com.example.passwordstore.navigation.NavRoute
import com.example.passwordstore.ui.theme.PasswordStoreTheme

@Composable
fun AddScreen(navController: NavHostController, viewModel: MainViewModel)
{
    var title by remember { mutableStateOf("") }
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false)}

    Scaffold()
    {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp))
            {
                Text(text = "Type title:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(8.dp))
                OutlinedTextField(
                    value = title,
                    onValueChange = {title = it
                        isButtonEnabled = title.isNotEmpty() && login.isNotEmpty() && password.isNotEmpty()},
                    label = { Text(text = "title")},
                    isError = title.isEmpty(),
                    modifier = Modifier.padding(40.dp))
            }
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp))
            {
                Text(text = "Type login:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(8.dp))
                OutlinedTextField(
                    value = login,
                    onValueChange = {login = it
                        isButtonEnabled = title.isNotEmpty() && login.isNotEmpty() && password.isNotEmpty()},
                    label = { Text(text = "login")},
                    isError = login.isEmpty(),
                    modifier = Modifier.padding(40.dp))
            }
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp))
            {
                Text(text = "Type password:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(8.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = {password = it
                        isButtonEnabled = title.isNotEmpty() && login.isNotEmpty() && password.isNotEmpty()},
                    label = { Text(text = "password")},
                    isError = password.isEmpty(),
                    modifier = Modifier.padding(40.dp))
            }
            Button(
                modifier = Modifier.padding(top = 16.dp),
                enabled = isButtonEnabled,
                onClick = {
                viewModel.addNote(note = Note(title = title, login = login, password = password))
                {
                    navController.navigate(NavRoute.Main.route)
                }
            })
            {
                Text(text = "Add")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevAddScreen()
{
    PasswordStoreTheme()
    {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        AddScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}