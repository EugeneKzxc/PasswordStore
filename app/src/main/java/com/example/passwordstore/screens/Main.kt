package com.example.passwordstore.screens

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun MainScreen(navController: NavHostController, viewModel: MainViewModel)
{
    val notes = viewModel.readAllNotes().observeAsState(listOf()).value

    Scaffold(floatingActionButton =
    { FloatingActionButton(onClick = {navController.navigate(NavRoute.Add.route)})
    {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add", tint = Color.White)
    }
    })
    {
        LazyColumn{
            items(notes) {note -> NoteItem(note = note, navController = navController, viewModel = viewModel)}
        }
    }
}

@Composable
fun NoteItem(note : Note, navController: NavHostController, viewModel: MainViewModel)
{
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp, horizontal = 24.dp),
        //.clickable { navController.navigate(NavRoute.Note.route) },
        elevation = 6.dp)
    {
        Column(modifier = Modifier
            .padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = note.title, fontSize = 40.sp, fontWeight = FontWeight.Bold)
            Text(text = note.login, fontSize = 24.sp)
            Text(text = note.password, fontSize = 24.sp)
            Button(onClick = {viewModel.deleteNote(note = note){} })
            {
                Text(text = "delete")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevMainScreen()
{
    PasswordStoreTheme()
    {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        MainScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}