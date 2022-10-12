package com.example.passwordstore.database.room.repository

import androidx.lifecycle.LiveData
import com.example.passwordstore.database.DataBaseRepository
import com.example.passwordstore.database.room.dao.NoteRoomDao
import com.example.passwordstore.model.Note

class RoomRepository(private val noteRoomDao: NoteRoomDao) : DataBaseRepository
{
    override val readAll: LiveData<List<Note>>
        get() = noteRoomDao.getAllNotes()

    override suspend fun create(note: Note, onSuccess: () -> Unit)
    {
        noteRoomDao.addNote(note = note)
        onSuccess()
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit)
    {
        noteRoomDao.deleteNote(note = note)
        onSuccess()
    }

    override suspend fun update(note: Note, onSuccess: () -> Unit)
    {
        noteRoomDao.updateNote(note = note)
        onSuccess()
    }
}