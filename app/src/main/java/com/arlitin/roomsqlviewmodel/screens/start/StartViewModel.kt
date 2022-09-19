package com.arlitin.roomsqlviewmodel.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.arlitin.roomsqlviewmodel.REPOSITORY
import com.arlitin.roomsqlviewmodel.db.NoteDatabase
import com.arlitin.roomsqlviewmodel.db.repository.NoteRealization
import com.arlitin.roomsqlviewmodel.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {

    private val context = application

    fun initDatabase(){
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }
    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}