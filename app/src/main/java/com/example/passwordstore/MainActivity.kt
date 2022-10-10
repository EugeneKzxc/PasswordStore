package com.example.passwordstore

import android.os.Bundle
import android.service.quicksettings.Tile
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.passwordstore.navigation.NavHost
import com.example.passwordstore.ui.theme.PasswordStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordStoreTheme {
                Scaffold(topBar = { TopAppBar(title = { Text(text = "PasswordStore")}, backgroundColor = Color.Blue, contentColor = Color.White, elevation = 12.dp)},
                        content = { Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background){ NavHost()}})
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PasswordStoreTheme {

    }
}}