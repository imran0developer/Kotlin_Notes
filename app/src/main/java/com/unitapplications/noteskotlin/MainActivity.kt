package com.unitapplications.noteskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = NoteDb.getInstance(application).noteDao()
        val factory = NoteVMFactory(dao)
        noteViewModel = ViewModelProvider(this,factory).get(NoteViewModel::class.java)

        save_bt.setOnClickListener(){
            saveNote()
            setRv()
        }
        setRv()
    }

    private fun setRv() {
        rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapter = Adapter()
        rv.adapter = adapter
        setAllNotes()
    }

    private fun setAllNotes() {
        noteViewModel.notes.observe(this){
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }

    }


    private fun saveNote(){
        noteViewModel.insertNote(
            NoteModel(
                0,
                et_title.text.toString(),
                et_note.text.toString()

            )
        )
    }
}