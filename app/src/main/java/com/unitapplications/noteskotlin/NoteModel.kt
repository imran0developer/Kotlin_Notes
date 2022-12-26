package com.unitapplications.noteskotlin

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int,
    @ColumnInfo(name = "title")
    var title:String,
    @ColumnInfo(name = "note")
    var note:String
)