package com.arlitin.roomsqlviewmodel.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arlitin.roomsqlviewmodel.REPOSITORY
import com.arlitin.roomsqlviewmodel.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {
    fun delete(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteNote(noteModel){
                onSuccess()
            }
        }
}