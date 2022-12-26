package com.unitapplications.noteskotlin

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(noteModel: NoteModel)
    @Update
    suspend fun updateNote(noteModel: NoteModel)
    @Delete
    suspend fun deleteNote(noteModel: NoteModel)
    @Query("SELECT * FROM Notes")
     fun getAllNotes():LiveData<List<NoteModel>>
}