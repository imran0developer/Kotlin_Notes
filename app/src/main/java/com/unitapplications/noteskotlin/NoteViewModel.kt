package com.unitapplications.noteskotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NoteViewModel(private val dao: NoteDao) : ViewModel(){
    val notes = dao.getAllNotes()

    fun insertNote(noteModel: NoteModel)=viewModelScope.launch {
        dao.insertNote(noteModel)
    }
    fun updateNote(noteModel: NoteModel)=viewModelScope.launch {
        dao.updateNote(noteModel)
    }
    fun deleteNote(noteModel: NoteModel)=viewModelScope.launch {
        dao.deleteNote(noteModel)
    }
}