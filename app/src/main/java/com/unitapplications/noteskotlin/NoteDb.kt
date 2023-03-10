package com.unitapplications.noteskotlin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteModel::class],version =1, exportSchema = false)
abstract class NoteDb :RoomDatabase(){

    abstract fun noteDao():NoteDao
    companion object{
        @Volatile
        private var INSTANCE : NoteDb?=null
        fun getInstance(context: Context):NoteDb{
            synchronized(this){
                var instance = INSTANCE
                if (instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDb::class.java,
                        "Note_db"
                    ).build()
                }
                return instance
            }
        }
    }

}