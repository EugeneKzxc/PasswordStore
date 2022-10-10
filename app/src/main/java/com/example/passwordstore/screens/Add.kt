package com.example.passwordstore.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.passwordstore.ui.theme.PasswordStoreTheme

@Composable
fun AddScreen(navController: NavHostController)
{
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                Text(text = "Type login:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(8.dp))
                OutlinedTextField(
                    value = login,
                    onValueChange = {login = it},
                    label = { Text(text = "login")},
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
                    onValueChange = {password = it},
                    label = { Text(text = "password")},
                    modifier = Modifier.padding(40.dp))
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
        AddScreen(navController = rememberNavController())
    }
}