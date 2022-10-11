package com.example.passwordstore

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.passwordstore.model.Note

class MainViewModel(application: Application) : AndroidViewModel(application)
{
    val readTest : MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }

    init
    {
        listOf<Note>(
            Note(title = "note_1", login = "login_1", password = "password_1"),
            Note(title = "note_2", login = "login_2", password = "password_2"),
            Note(title = "note_3", login = "login_3", password = "password_3"),
            Note(title = "note_4", login = "login_4", password = "password_4")
        )
    }

    fun initDatabase()
    {
        Log.d("CheckData", "MainViewModel initDataBase")
    }
}


class  MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
        {
            return MainViewModel(application = application) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")
    }
}