package com.unitapplications.noteskotlin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NoteVMFactory(private val dao: NoteDao): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)){
            return NoteViewModel(dao) as T
        }
        throw IllegalArgumentException ("Unknow numerial value")


    }
}