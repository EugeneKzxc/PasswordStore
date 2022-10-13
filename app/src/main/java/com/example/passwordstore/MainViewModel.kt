package com.example.passwordstore

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.passwordstore.Utils.REPOSITORY
import com.example.passwordstore.database.room.AppRoomDatabase
import com.example.passwordstore.database.room.repository.RoomRepository
import com.example.passwordstore.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application)
{
    val context = application

    fun initDatabase()
    {
        val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
        REPOSITORY = RoomRepository(dao)
    }

    fun addNote(note: Note, onSuccess : () -> Unit)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            REPOSITORY.create(note = note)
            {
                viewModelScope.launch(Dispatchers.Main)
                {
                    onSuccess()
                }
            }
        }
    }

    fun deleteNote(note: Note, onSuccess: () -> Unit)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            REPOSITORY.delete(note)
            {
                viewModelScope.launch(Dispatchers.Main)
                {
                    onSuccess()
                }
            }
        }
    }

    fun readAllNotes() = REPOSITORY.readAll
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