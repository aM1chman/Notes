package com.arlitin.roomsqlviewmodel.db.repository

import androidx.lifecycle.LiveData
import com.arlitin.roomsqlviewmodel.db.dao.NoteDao
import com.arlitin.roomsqlviewmodel.model.NoteModel

class NoteRealization(private val noteDao: NoteDao): NoteRepository {

    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(note: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel = NoteModel())
        onSuccess()
    }

    override suspend fun deleteNote(note: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel = NoteModel())
        onSuccess()
    }

}